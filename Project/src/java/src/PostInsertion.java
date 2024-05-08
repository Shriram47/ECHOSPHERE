/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class PostInsertion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostInsertion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostInsertion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       try {
            
            response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter(); 
                  out.println("above html");
                  
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>POST INSERTION</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>POST INSERTION" + request.getContextPath() + "</h1>");
               
                int counter=0;
           String username="NOT FOUND";//=(String)request.getAttribute("Username");
            String first_name="NO FIRST NAME";//=(String)request.getAttribute("User_first_name");
            String last_name="NO LAST NAME";//=(String)request.getAttribute("User_last_name");*/
        String mailid="NO mAIL ID";
        String password="NO PASSWORD";
            Cookie[] crs=request.getCookies();
            
          for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERNAME"))
                         {
                          username=irs.getValue();
                          counter++;
                          break;
        }
        }  for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERFIRST"))
                         {
                          first_name=irs.getValue();
                          counter++;
                          break;
        }
        }  for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERLAST"))
                         {
                          last_name=irs.getValue();
                          counter++;
                          break;
        }
        }for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERMAILD"))
                         {
                          mailid=irs.getValue();
                          counter++;
                          break;
        }
        }
        for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERPASSWORD"))
                         {
                          password=irs.getValue();
                          counter++;
                          break;
        }
        }
        if(counter!=5)
        { response.sendRedirect("please.html");}
              out.println("COUNTER:"+counter);
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
          //  String maili=request.getParameter("mail");
          // String userpassword=request.getParameter("userpassword");
            int id=0;
            out.println(username+" "+first_name+""+last_name+" "+mailid+" "+password);
            PreparedStatement ps=con.prepareStatement("select id from userinfo where user_mail_id=? and user_password=?");
           ps.setString(1,mailid );
           ps.setString(2,password);
           System.out.println("MAIl id: "+mailid+"\nUSERPASSWORD: "+password);
            ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
              id=rs.getInt("id");
              out.println(id);
             }
             java.util.Date now=  new java.util.Date();
             java.sql.Date present= new java.sql.Date(now.getTime());
             out.println(present);
             String title=request.getParameter("title");
             String genre=request.getParameter("genre");
             String subgenre=request.getParameter("subgenre");
             String content=request.getParameter("content");
             
            PreparedStatement ps2=con.prepareStatement("insert into post(post_title,genre,user_id,Content,published,sub_genre) value(?,?,?,?,?,?);");
            
            ps2.setString(1,title);
            ps2.setString(2,genre);
            ps2.setInt(3, id);
            ps2.setString(4,content);
            ps2.setDate(5,present);
            ps2.setString(6,subgenre);
            
                    int check=ps2.executeUpdate();
                    out.println("check value is"+ check);
                    if(check!=1)
                    {response.sendRedirect("Please.html");}
                     out.println("<hr><h3>POST INSERTED SUCCESSFULLY: </h3>");
                     out.println("<br><h4>VIEW PROFILE<a href='viewProfile.jsp'>CLICK HERE..</a></h4>");
             //        response.sendRedirect("Members.jsp");
                out.println("</body>");
                out.println("</html>");
            
          
            
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
