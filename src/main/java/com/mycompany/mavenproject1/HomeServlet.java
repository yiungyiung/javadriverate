/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.UserService.UserServiceImpl;
import com.mycompany.mavenproject1.model.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yash
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.equals("/")) {
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
            System.out.println(request.getParameter("state"));
        } else if (uri.equals("/addcomment")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                request.getRequestDispatcher("/WEB-INF/view/addcomment.jsp").forward(request, response);
            } else if (method.equals("POST")) {
            }
        } else if (uri.equals("/rankings")) {
            request.getRequestDispatcher("/WEB-INF/view/rankings.jsp").forward(request, response);
        } else if (uri.equals("/register")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
            } else if (method.equals("POST")) {
                // Retrieve parameters from the form
                String username = request.getParameter("username");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address") + " " + request.getParameter("city") + " " + request.getParameter("country");
                String password = request.getParameter("password");
                String phone = request.getParameter("phone");
                int l = UserServiceImpl.getInstance().register(name, password, address, email, phone, username);
                if (l == 1) {
                    // Registration successful, redirect to the main page
                    response.sendRedirect("/login");
                } else {
                    // Registration failed, display an alert message
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Registration failed. Please try again.');");
                    out.println("window.location.href='/register';");
                    out.println("</script>");
                }
            }
        } else if (uri.equals("/login")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            } else if (method.equals("POST")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String l = UserServiceImpl.getInstance().login(email, password);
                if (l == null) {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Login failed. Please try again.');");
                    out.println("window.location.href='/login';");
                    out.println("</script>");
                } else {
                    response.sendRedirect("/main");
                }
            }
        } else if (uri.equals("/error404")) {
            request.getRequestDispatcher("/WEB-INF/view/error404.jsp").forward(request, response);
        }
        else{
             response.sendRedirect("/error404");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
