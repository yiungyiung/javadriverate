/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.UserDAO.UsersDAO;
import com.mycompany.mavenproject1.model.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        /*System.out.println(uri + "Yash");
        ArrayList<UserModel> users = new ArrayList<>();
        users.add(new UserModel("y", 12, "y@y"));
        users.add(new UserModel("a", 12, "a@a"));
        users.add(new UserModel("s", 12, "s@s"));
        users.add(new UserModel("t", 12, "5@t","yashrocks"));
        for (int i = 0; i < 4; i++) {
            System.out.println((users.get(i)).name);
        }
        //UsersDAO.getInstance().save(users.get(3));
        request.setAttribute("users1", users);
        String uname = request.getParameter("userName");
        request.setAttribute("varchange", uname);*/
        
        if (uri.equals("/")) {
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
            System.out.println(request.getParameter("state"));
        }
        else if(uri.equals("/addcomment")){
            request.getRequestDispatcher("/WEB-INF/view/addcomment.jsp").forward(request, response);
        }
        else if(uri.equals("/rankings")){
            request.getRequestDispatcher("/WEB-INF/view/rankings.jsp").forward(request, response);
        }
        else if(uri.equals("/register")){
            request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
        }
        else if(uri.equals("/login")){
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
        else if(uri.equals("/error404"))
        {
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
