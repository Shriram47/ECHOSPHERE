/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package src;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class Validation extends HttpServlet {

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
        
        try {
            
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
            PreparedStatement ps=con.prepareStatement("select * from userinfo");
            ResultSet rs=ps.executeQuery();
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet VALid</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet VALID at " + request.getContextPath() + "</h1>");
                while(rs.next())
                {     int id =rs.getInt(1);
                    String username=rs.getString(2);
                    String mailid=rs.getString(3);
                    String firstname=rs.getString(4);
                     String lastname=rs.getString(5);
                      String password=rs.getString(6);
                      Date created=rs.getDate(7);
                      int age=rs.getInt("age");
                    out.println("<h3>USER ID: "+id+"<br>USER MAIL_ID: "+mailid+"<br>USER FIRST_NAME: "+firstname+"<br>USER LAST_NAME: "+lastname+"<br>USER PASSWORD: "+password+"<br>Account Created: "+created+"<br>USER AGE: "+age+"<br>********************</h3>");
                }
                out.println("</body>");
                out.println("</html>");
            }
          
            
        }
        catch(SQLException ex)
        {
           System.out.println("SQL EXCEPtion occure: "+ex);
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
           try {
            
            ServletContext sctxt=super.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
            PreparedStatement ps=con.prepareStatement("select * from userinfo");
            ResultSet rs=ps.executeQuery();
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet VALID GET</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet VALID GET " + request.getContextPath() + "</h1>");
                while(rs.next())
                {
                     int id =rs.getInt(1);
                    String username=rs.getString(2);
                    String mailid=rs.getString(3);
                    String firstname=rs.getString(4);
                     String lastname=rs.getString(5);
                      String password=rs.getString(6);
                      Date created=rs.getDate(7);
                      int age=rs.getInt("age");
                    out.println("<h3>USER ID: "+id+"<br>USER MAIL_ID: "+mailid+"<br>USER FIRST_NAME: "+firstname+"<br>USER LAST_NAME: "+lastname+"<br>USER PASSWORD: "+password+"<br>Account Created: "+created+"<br>USER AGE: "+age+"<br>********************</h3>");
                 }
                out.println("</body>");
                out.println("</html>");
            }
          
            
        }
        catch(SQLException ex)
        {
           System.out.println("SQL EXCEPtion occure: "+ex);
        }
        
        
        
        
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
    System.out.println("START VALIDATION");
           try {
              
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
            String mailid=request.getParameter("mail");
            String userpassword=request.getParameter("userpassword");
            
            PreparedStatement ps=con.prepareStatement("select id,user_name,user_first_name,user_last_name from userinfo where user_mail_id=? and user_password=?");
           ps.setString(1,mailid );
           ps.setString(2,userpassword);
           System.out.println("MAIl id: "+mailid+"\nUSERPASSWORD: "+userpassword);
            ResultSet rs=ps.executeQuery();
            PreparedStatement ps2=con.prepareStatement("select * from post order by RAND() limit 15;");
                    ResultSet set=ps2.executeQuery();
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                  out.println("above html");
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet VALIDATION POST</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet VLAIDATION POST " + request.getContextPath() + "</h1>");
                if(rs.next())
                {
                 int userid=rs.getInt("id");
                    String username=rs.getString("user_name");
                    String user_first_name=rs.getString("user_first_name");
                    String user_last_name=rs.getString("user_last_name");
                                   out.println("<h2>input taken from result set for varification</h2>");  
                    request.setAttribute("USERID",userid);
                    request.setAttribute("Username", (String)username);
                    request.setAttribute("User_first_name", (String)user_first_name);
                    request.setAttribute("User_last_name", (String)user_last_name);
                    request.setAttribute("Mailid", mailid);
                    request.setAttribute("Userpassword",userpassword);
                   out.println(username+" "+user_first_name+" "+user_last_name);
                   System.out.println(username+" "+user_first_name+" "+user_last_name);
                  out.println("<h3>set attribute</h3>");
                   // response.sendRedirect("Members.jsp");
             // request.setAttribute("message", message);
             request.setAttribute("THE RESULT SET",set);
        request.getRequestDispatcher("intermediater").forward(request, response);
               
       // response.sendRedirect("Member.jsp");
        out.println("REFERESH PAGE");
                    }
                else{
                        response.sendRedirect("invalidUser.html");
                        }
                out.println("</body>");
                out.println("</html>");
            }
          
            
        }
        catch(SQLException ex)
        {
           System.out.println("SQL EXCEPtion occure: "+ex);
        }
        
        
        
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
