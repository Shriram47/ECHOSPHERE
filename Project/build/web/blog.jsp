<%-- 
    Document   : blog
    Created on : May 7, 2024, 5:51:34 PM
    Author     : HP
--%>

<%@page contentType="text/html" import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BLOG JSP</title>
    </head>
    <body>
        <%
            String AUTHOR_USERNAME="NOT FOUND",AUTHOR_FIRST_NAME="NOT FOUND NAME",AUTHOR_LAST_NAME="LASTNAME NOT FOUND";
         int id=Integer.parseInt(request.getParameter("identi"));
         int userid=0;
         String title="NO TITLE",genre="NO GENRE",sub_genre="NO SUB_GENRE",content="NO CONTENT";
      /* String genre=(String)request.getParameter("generis");
       String subgenre=(String)request.getParameter("subis");
       String Content=(String)request.getParameter("contentis");*/
        //Connceting from database
        try{
            ServletContext sc=request.getServletContext();
            Connection con=(Connection)sc.getAttribute("CONNECTION");
           // System.out.println("CONNCETION OBJECT FOUND");
            PreparedStatement ps=con.prepareStatement("Select * from post where post_id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
          
            if(rs.next())
            { title=rs.getString("post_title");
                  genre=rs.getString("genre");
                 sub_genre=rs.getString("sub_genre");
                 content=rs.getString("Content");
                userid=rs.getInt("user_id");
                
            }
              PreparedStatement ps2=con.prepareStatement("select user_name,user_first_name,user_last_name from userinfo where id=?;");
             ps2.setInt(1, userid);
              ResultSet rs2=ps2.executeQuery();
              if(rs2.next())
              {
               AUTHOR_USERNAME=rs2.getString(1);
               AUTHOR_FIRST_NAME=rs2.getString(2);
               AUTHOR_LAST_NAME=rs2.getString(3);
            }
            
            
            }
            
        catch(Exception ex)
        {
       // System.out.println("SoME EXCEPTION OCCURED (INSIDE BLOG): "+ex.getMessage());
            }
                
        %>
       
        <h2>PUBLISHED BY: <%=AUTHOR_USERNAME%><br>USERNAME: <%=AUTHOR_FIRST_NAME+" "+AUTHOR_LAST_NAME%><br></h2>
        
      <!--  
       <form  action="ThroughBlogProfile.jsp?" method="post">
    <button type="submit">Go to AUTHOR PROFILE</button><hr><hr>
</form>
        -->
        <hr><hr><br>
        <h2>TITLE: <%=title%></h2><br>
        
        <h3>GENRE/SUB_GENRE: <%=genre+"/ "+sub_genre%></h3><br>
        <h2>CONTENT: </h3>
        <h3><%=content%></h3><br>
        <hr style="border-top: 1px dashed #ccc;">

            
    </body>
</html>
