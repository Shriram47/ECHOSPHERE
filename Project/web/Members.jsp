<%-- 
    Document   : Members
    Created on : May 6, 2024, 12:58:14 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSIDE APPLICATION</title>
    </head>
    <body>
        <%
          int count=0;
          int userid=0;
            String username="NOT FOUND";//=(String)request.getAttribute("Username");
            String first_name="NO FIRST NAME";//=(String)request.getAttribute("User_first_name");
            String last_name="NO LAST NAME";//=(String)request.getAttribute("User_last_name");*/
        String maildid="NO mAIL ID";
        String password="NO PASSWORD";
            Cookie[] crs=request.getCookies();
          for(Cookie irs:crs)
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
        } for(Cookie irs:crs)
          {
                         if(irs.getName().equals("USERID"))
                         {
                          userid=Integer.parseInt(irs.getValue());
                        //  out.println(userid);
                          request.setAttribute("useridishere", userid);
                          break;
        }
        }
        if(count!=3){
        response.sendRedirect("Please.html");
        }
            %>
            <h1>WELCOME, <%=username%> </h1>
            <h2>AKA: <%= first_name+" "+last_name%></h2><hr style="border-top: 1px double black;">
            <!-- CONTENT DISPLAY -->
        
                <button onclick="viewProfile()">View Profile</button>
                  <button onclick="postBlog()">Post New Blog</button>

    
  <!-- Add more buttons as needed -->

<hr><hr>
            <h1>Select Blogs Genres</h1>

<div id="genreButtons">
  <button onclick="navigateToPage('biography')">Biography</button>
 <button onclick="navigateToPage('fiction')"> Fiction</button>
  <button onclick="navigateToPage('technology')">Technology</button>
  <button onclick="navigateToPage('story')">Story</button>
    <button onclick="navigateToPage('other')">SUB GENRE</button>
    
  <!-- Add more buttons as needed -->
</div>
<hr><hr>
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
   java.sql.ResultSet rs=(java.sql.ResultSet)request.getAttribute("RESULTSET");
 
    while(rs.next())
    
    {int id=rs.getInt("post_id");
    String title=rs.getString("post_title");
    String genre=rs.getString("genre");
    String sub_genre=rs.getString("sub_genre");
    String content=rs.getString("Content");
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

out.println("<h3>"+shortcontent+"<h4><a href='blog.jsp?identi="+id+"'>READ MORE...</a></h4></h3>");
out.println("<hr><br>");
}

%>
<hr><hr>
<script>
      function viewProfile() {
            // Redirect to the JSP file for viewing profile
            window.location.href = "viewProfile.jsp";
        }

        function postBlog() {
            // Redirect to the JSP file for posting a new blog
            window.location.href = "postBlog.jsp";
        }
function navigateToPage(genre) {
  // Construct the JSP page URL based on the selected genre
  var jspPage = genre;
  
  // Redirect to the constructed JSP page
  window.location.href = jspPage;
}
          
           
</script>

            
            
            
            
    </body>
</html>
