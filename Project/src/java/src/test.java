/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class test extends HttpServlet {

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
        response.setContentType("text/html");
        
        // Generate HTML content dynamically for the buttons
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html>");
        htmlContent.append("<head><title>Select Blogs Genres</title></head>");
        htmlContent.append("<body>");
        htmlContent.append("<h1>Select Blogs Genres</h1>");
        htmlContent.append("<div id=\"genreButtons\">");
        htmlContent.append("<button onclick=\"navigateToPage('biography')\">Biography</button>");
        htmlContent.append("<button onclick=\"navigateToPage('fiction')\">Fiction</button>");
        htmlContent.append("<button onclick=\"navigateToPage('technology')\">Technology</button>");
        htmlContent.append("<button onclick=\"navigateToPage('story')\">Story</button>");
        htmlContent.append("<button onclick=\"navigateToPage('other')\">SUB GENRE</button>");
        htmlContent.append("</div>");
        htmlContent.append("</body>");
     response.getWriter().println("function navigateToPage(genre) {");
        response.getWriter().println("var jspPage = 'Verification';");
        response.getWriter().println("var mailid = 'user@example.com';"); // Replace with actual mailid
        response.getWriter().println("var password = 'password123';"); // Replace with actual password
        response.getWriter().println("var url = jspPage + '?mailid=' + encodeURIComponent(mailid) + '&password=' + encodeURIComponent(password) + '&genre=' + genre;");
        response.getWriter().println("window.location.href = url;");
        response.getWriter().println("}");
        htmlContent.append("</html>");
        
        // Write the HTML content to the response
        response.getWriter().println(htmlContent.toString());
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
