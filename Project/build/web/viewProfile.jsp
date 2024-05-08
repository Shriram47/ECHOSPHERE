<%-- 
    Document   : viewProfile
    Created on : May 8, 2024, 3:04:00 PM
    Author     : HP
--%>

<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!

    public static String trimTo100Words(String originalString) {
        String[] words = originalString.split("\\s+");
        if (words.length <= 10) {
            return originalString; // Return original string if it already has 100 or fewer words
        }
        StringBuilder trimmedStringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            trimmedStringBuilder.append(words[i]).append(" ");
        }
        return trimmedStringBuilder.toString().trim().concat("....");
    }
 
%>
        <%
         ServletContext sc=request.getServletContext();
        java.sql.Connection con =(java.sql.Connection)sc.getAttribute("CONNECTION");
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
       // Integer id= (Integer)request.getAttribute("useridishere");
        java.sql.PreparedStatement ps2= con.prepareStatement("select * from userinfo where user_mail_id=?");
        ps2.setString(1, mailid);
       java.sql.ResultSet rs2=ps2.executeQuery();
       java.sql.Date created=null;
       int id=0;
       String Username="empty",UserFirstName="hollow",UserLastName="not get",Mailid="not found";
       if(rs2.next())
       {
        id=rs2.getInt("id");
        Username=rs2.getString("user_name");
        Mailid=rs2.getString("user_mail_id");
        UserFirstName =rs2.getString("user_first_name");
        UserLastName =rs2.getString("user_last_name");
        created=rs2.getDate("created");
        
        }
         java.sql.PreparedStatement ps3= con.prepareStatement("select * from post where user_id=?");
        ps3.setInt(1, id);
       java.sql.ResultSet rs3=ps3.executeQuery();
       
       
        
        %>
        
        
        <h2>USER_NAME: <%=Username%></h2>
        <h2>NAME: <%=UserFirstName+" "+UserLastName%></h2>
       <h2> MAIL_ID: <%=Mailid%></h2>
           <h2>ACCOUNT CREATED:<%=created%></h2>
     <hr><hr>
     <h3>YOUR BLOG LISTS: </h3>
     <% 
          int total=0;
   
 
    while(rs3.next())
    
    {total++;
    int postid=rs3.getInt("post_id");
    String title=rs3.getString("post_title");
    String genre=rs3.getString("genre");
    String sub_genre=rs3.getString("sub_genre");
    String content=rs3.getString("Content");
    String shortcontent= trimTo100Words(content);
   

String encodedTitle = java.net.URLEncoder.encode(title, "UTF-8");
out.println("<h2>TITLE: "+title+"<h2>");



out.println("<h3>Genre: "+genre+"<h3>");
out.println("<h3>Sub_Genre: "+sub_genre+"</h3>");
out.println("<h2 >CONTENT: </h2>");
/*String fogo= replaceSpacesWithDollar(title);

Cookie ck=new Cookie("titis",fogo);
response.addCookie(ck);
*/

out.println("<h3>"+shortcontent+"<h4><a href='blog.jsp?identi="+postid+"'>READ MORE...</a></h4></h3>");
out.println("<hr><br>");
}
if(total==0)
{out.println("<h3>NO BLOG YET POSTED</h3>");}

else
{
   out.println("<h3>YOU HAVE TOTAl "+total+" BLOGS POSTED</h3>");}  

%>
<h3
    </body>
</html>
