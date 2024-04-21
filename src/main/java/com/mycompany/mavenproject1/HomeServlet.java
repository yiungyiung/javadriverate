/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.UserService.UserServiceImpl;
import com.mycompany.mavenproject1.model.Rating;
import com.mycompany.mavenproject1.model.UserModel;
import com.mycompany.mavenproject1.model.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yash
 */
@MultipartConfig
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
            Rating rt = UserServiceImpl.getInstance().getLatestRating();
            System.out.println(rt.getVehicleNumber());
            request.getSession().setAttribute("ratingindex",rt);
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
            System.out.println(request.getParameter("state"));
        } else if (uri.equals("/addcomment")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                request.getRequestDispatcher("/WEB-INF/view/addcomment.jsp").forward(request, response);
            } else if (method.equals("POST")) {
                String vehicleNumber = request.getParameter("number");
                String state = request.getParameter("state");
                String comment = request.getParameter("comment");
                boolean goodRating = "good".equals(request.getParameter("rating"));
                boolean badRating = !goodRating;
                double latitude = Double.parseDouble(request.getParameter("latitude"));
                double longitude = Double.parseDouble(request.getParameter("longitude"));

                // Get picture
                Part picturePart = request.getPart("picture");
                InputStream pictureStream = picturePart.getInputStream();
                byte[] pictureBytes = pictureStream.readAllBytes();

                boolean success = UserServiceImpl.getInstance().addRating(vehicleNumber, goodRating, badRating, pictureBytes, comment, latitude, longitude);

                // Redirect based on success
                if (success) {
                    // Registration successful, redirect to the main page
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Success');");
                    out.println("window.location.href='/';");
                    out.println("</script>");
                } else {
                    // Registration failed, display an alert message
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('failed. Please try again.');");
                    out.println("window.location.href='/addcomment';");
                    out.println("</script>");
                }
            }
        } else if (uri.equals("/rankings")) {
            Map<String, Integer> bestRankingsMap = UserServiceImpl.getInstance().getBestVehiclesWithGoodVotes();
            Map<String, Integer> worstRankingsMap = UserServiceImpl.getInstance().getWorstVehiclesWithNegativeVotes();

            // Sort the entries based on the values (votes)
            List<Map.Entry<String, Integer>> bestRankingsList = new ArrayList<>(bestRankingsMap.entrySet());
            bestRankingsList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // Descending order
            List<Map.Entry<String, Integer>> worstRankingsList = new ArrayList<>(worstRankingsMap.entrySet());
            worstRankingsList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); 

            // Put the sorted lists into the request attributes
            request.setAttribute("bestRankings", bestRankingsList);
            request.setAttribute("worstRankings", worstRankingsList);
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
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Success');");
                    out.println("window.location.href='/login';");
                    out.println("</script>");

                } else {
                    // Registration failed, display an alert message
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Registration failed. Please try again.');");
                    out.println("window.location.href='/register';");
                    out.println("</script>");
                }
            }
        } else if (uri.equals("/myvehicles")) {
            String method = (String) request.getMethod();
            if (method.equals("GET")) {
                if(request.getSession().getAttribute("anom")!=null){
                if (((String) request.getSession().getAttribute("anom")).equals("0")) {
                    System.out.println("invheicles");
                    String Email = (String) request.getSession().getAttribute("username");
                    List<Vehicle> ls = UserServiceImpl.getInstance().getAllVehiclesForUser(Email);
                    if (ls != null) {
                        request.setAttribute("vehicles", ls); // Set the list of vehicles as an attribute
                        request.getRequestDispatcher("/WEB-INF/view/myvehicles.jsp").forward(request, response);
                    }
                }
                }
            }

        } else if (uri.equals("/comments")) {
            String method = request.getMethod();
            if (method.equals("GET")) {

                String Email = (String) request.getSession().getAttribute("username");
                List<Rating> ls = UserServiceImpl.getInstance().getAllRatings();
                if (ls != null) {
                    request.setAttribute("ratings", ls); // Set the list of vehicles as an attribute
                    request.getRequestDispatcher("/WEB-INF/view/comments.jsp").forward(request, response);
                }

            }

        } else if (uri.equals("/search")) {

            String method = request.getMethod();
            if (method.equals("GET")) {
                String sr = request.getParameter("value");
                List<Rating> rt = UserServiceImpl.getInstance().searchRatingsBySubstring(sr);
                request.setAttribute("ratings", rt);
                request.getRequestDispatcher("/WEB-INF/view/search.jsp").forward(request, response);
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
                    request.getSession().setAttribute("username", l);
                    request.getSession().setAttribute("id", "NA");
                    request.getSession().setAttribute("anom", "0");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Success');");
                    out.println("window.location.href='/';");
                    out.println("</script>");
                }
            }
        } else if (uri.equals("/error404")) {
            request.getRequestDispatcher("/WEB-INF/view/error404.jsp").forward(request, response);
        } else if (uri.equals("/anomuser")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                request.getRequestDispatcher("/WEB-INF/view/anomuser.jsp").forward(request, response);
            } else {
                String userstr = request.getParameter("username");
                List<String> ls = UserServiceImpl.getInstance().anomlogin(userstr);
                if (ls == null) {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('failed. Please try again.');");
                    out.println("window.location.href='/login';");
                    out.println("</script>");
                } else {

                    request.getSession().setAttribute("username", ls.get(1));
                    request.getSession().setAttribute("id", ls.get(0));
                    request.getSession().setAttribute("anom", "1");
                    response.sendRedirect("/");
                }
            }
        } else if (uri.equals("/logout")) {
            request.getSession().invalidate();
            response.sendRedirect("/");
        } else if (uri.equals("/addvehicle")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                if (request.getSession().getAttribute("anom").equals("0")) {
                    request.getRequestDispatcher("/WEB-INF/view/addvehicle.jsp").forward(request, response);
                }
            } else {
                if (request.getSession().getAttribute("anom").equals("0")) {
                    String vehicleNumber = request.getParameter("vehicleNumber");
                    String year = request.getParameter("year");
                    String manufacturer = request.getParameter("manufacturer");
                    String model = request.getParameter("model");
                    String color = request.getParameter("color");
                    String vehicleCategory = request.getParameter("vehicleCategory");

// Print the values
                    boolean st = UserServiceImpl.getInstance().addVehicle(vehicleNumber, Integer.parseInt(year), manufacturer, model, color, vehicleCategory, (String) request.getSession().getAttribute("username"));
                    if (st) {
                        PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Success');");
                        out.println("window.location.href='/';");
                        out.println("</script>");
                    } else {
                        PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('failed. Please try again.');");
                        out.println("window.location.href='/addvehicle';");
                        out.println("</script>");
                    }
                }
            }
        } else if (uri.equals("/logoutanom")) {
            String id = (String) request.getSession().getAttribute("id");
            boolean st = UserServiceImpl.getInstance().deleteAnomUser(id);
            request.getSession().invalidate();
            response.sendRedirect("/");
        } else if (uri.equals("/notifyClose")) {
            if (request.getSession().getAttribute("anom").equals("1")) {
                System.out.println("mast");
                String id = (String) request.getSession().getAttribute("id");
                boolean st = UserServiceImpl.getInstance().deleteAnomUser(id);
                request.getSession().invalidate();
            }
        } else {
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
