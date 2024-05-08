/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package src;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class Registration extends HttpServlet {

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
    PrintWriter out = response.getWriter();
           try {
            
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
            String mailid=request.getParameter("mail");
            String userpassword=request.getParameter("userpassword");
            PreparedStatement ps=con.prepareStatement("insert into userinfo(user_mail_id,user_name,user_first_name,user_last_name,age,user_password,created)values(?,?,?,?,?,?,?)");
           
           
            
            response.setContentType("text/html;charset=UTF-8");
            
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet VALIDATION POST</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet VLAIDATION POST " + request.getContextPath() + "</h1>");
               
          
            String Mail=request.getParameter("mail");
            String Name=request.getParameter("username");
             Integer Age=Integer.parseInt(request.getParameter("age"));
             String FirstName=request.getParameter("firstname");
             String LastName=request.getParameter("lastname");
             String Password=request.getParameter("userpassword");
             //
             java.util.Date now= new java.util.Date();
         
             
             //
            ps.setString(1,Mail );
           ps.setString(2,Name);
           ps.setString(3,FirstName);
           ps.setString(4,LastName);
           ps.setInt(5,Age);
           ps.setString(6, Password);
        
           ps.setTimestamp(7, new java.sql.Timestamp(now.getTime()));
           
            int done=ps.executeUpdate();
                if(done==1)
                {
                  /* int id =rs.getInt(1);
                    String username=rs.getString(2);
                    String mailid=rs.getString(3);
                    String firstname=rs.getString(4);
                     String lastname=rs.getString(5);
                      String password=rs.getString(6);
                      Date created=rs.getDate(7);
                      int age=rs.getInt("age");
                    out.println("<h3>USER ID: "+id+"<br>USER MAIL_ID: "+mailid+"<br>USER FIRST_NAME: "+firstname+"<br>USER LAST_NAME: "+lastname+"<br>USER PASSWORD: "+password+"<br>Account Created: "+created+"<br>USER AGE: "+age+"<br>********************</h3>");
                 */
                response.sendRedirect("DoneRegister.html");
                }
                else{
                        response.sendRedirect("invalidRegistration.html");
                        }
              
            
          
            
        }
        catch(SQLException ex)
        { response.sendRedirect("invalidRegistration.html");
           System.out.println("SQL EXCEPtion occure: "+ex);
        } /*catch (ParseException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }*/
           finally{
                 out.println("</body>");
                out.println("</html>");
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
