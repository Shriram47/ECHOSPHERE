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
import static src.technology.trimTo100Words;

/**
 *
 * @author HP
 */
public class story extends HttpServlet {
      public static String trimTo100Words(String originalString) {
        String[] words = originalString.split("\\s+");
        if (words.length <= 10) {
            return originalString; 
        }
        StringBuilder trimmedStringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            trimmedStringBuilder.append(words[i]).append(" ");
        }
        return trimmedStringBuilder.toString().trim().concat("....");
    }

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
            out.println("<title>Servlet story</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>STORY EXPLORE</h1>");
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
        
          int count=0;
            String username="NOT FOUND";//=(String)request.getAttribute("Username");
            String first_name="NO FIRST NAME";//=(String)request.getAttribute("User_first_name");
            String last_name="NO LAST NAME";//=(String)request.getAttribute("User_last_name");*/
       
            Cookie[] crs=request.getCookies();
         try{ for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERNAME"))
                         {
                          username=irs.getValue();
                          count++;
                          break;
        }
        }  for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERFIRST"))
                         {
                          first_name=irs.getValue();
                          count++;
                          break;
        }
        }  for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERLAST"))
                         {
                          last_name=irs.getValue();
                          count++;
                          break;
        }
        }
        if(count!=3){
        response.sendRedirect("fakelogin.html");
        }}
catch(NullPointerException ex)
           {response.sendRedirect("fakelogin.html");
           }
         try {
              
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
            String mailid=request.getParameter("mail");
            String userpassword=request.getParameter("userpassword");
            
            PreparedStatement ps=con.prepareStatement("select * from post where genre='story' order by RAND()");
                ResultSet rs=ps.executeQuery();
                       
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                //  out.println("above html");
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>STORY EXPLORE</title>");
                out.println("</head>");
                out.println("<body>");
                                 out.println("<h2>WELCOME, "+username+"</h2>");
                out.println("<h3>AKA: "+first_name.concat(" ".concat(last_name))+"</h3><hr><br>");
                out.println("<h1>STORY BLOGS</h1><hr>");
                
                //
                  out.println("<h1>Select Blogs Genres</h1>");
        out.println("<div id=\"genreButtons\">");
     //   out.println("<button onclick=\"navigateToPage('intermediater')\">EXPLORER </button>");
        out.println("<button onclick=\"navigateToPage('fiction')\">Fiction</button>");
        out.println("<button onclick=\"navigateToPage('technology')\">Technology</button>");
        out.println("<button onclick=\"navigateToPage('biography')\">biography</button>");
        out.println("<button onclick=\"navigateToPage('other')\">SUB GENRE</button>");
        out.println("</div>");
          out.println("<script>");
        out.println("function navigateToPage(genre) {");
        out.println("var jspPage = genre;");
        out.println("window.location.href = jspPage;");
        out.println("}");
        out.println("</script>");
            out.println("<br><hr>");
                //

               int counter=0;
                while(rs.next())
                {counter++;
                 int id=rs.getInt("post_id");

                   String title=rs.getString("post_title");
    String genre=rs.getString("genre");
    String sub_genre=rs.getString("sub_genre");
    String content=rs.getString("Content");
   String contentshort= trimTo100Words(content);
    out.println("<h2>TITLE: "+title+"<h2>");
      out.println("<h3>Genre: "+genre+"<h3>");
       out.println("<h3>Sub_Genre: "+sub_genre+"</h3>");
       out.println("<h2 >CONTENT: </h2>");
          // out.println("<h2>"+contents+"</h2>");
           out.println("<h2>"+contentshort.concat("...")+"</h2>");
out.println("<h3><a href='blog.jsp?identi="+id+"'>READ MORE...</a></h3>");
           out.println("<br><hr><br>");
             }if(counter==0)
             {
              out.println("<h2>NOT CONTENT AVAILABLE FOR THE STORY </h2>");
             }
             else
             {
              out.println("<h2>YOU HAVE SEEN: "+counter+" blogs </h2>");
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
        try {
              
            ServletContext sctxt=request.getServletContext();
            Connection con=(Connection)sctxt.getAttribute("CONNECTION");
        
            
            PreparedStatement ps=con.prepareStatement("select * from post where genre='story'");
                ResultSet rs=ps.executeQuery();
                       
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                //  out.println("above html");
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>SUB GENRE EXPLORE</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>SUB GENRE BLOGS</h1><hr>");
               int count=0;
                while(rs.next())
                {count++;
                 
                   String title=rs.getString("post_title");
    String genre=rs.getString("genre");
    String sub_genre=rs.getString("sub_genre");
    String content=rs.getString("Content");
   
    out.println("<h2>TITLE: "+title+"<h2>");
      out.println("<h3>Genre: "+genre+"<h3>");
       out.println("<h3>Sub_Genre: "+sub_genre+"</h3>");
       out.println("<h2 >CONTENT: </h2>");
           out.println("<h2>"+content+"</h2>");
           out.println("<br><hr><br>");
             }if(count==0)
             {
              out.println("<h2>NOT CONTENT AVAILABLE FOR THE SUB_GRENRE </h2>");
             }
             else
             {
              out.println("<h2>YOU HAVE SEEN: "+count+" blogs </h2>");
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
