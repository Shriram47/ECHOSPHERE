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
        <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-top: 0;
        }
        p {
            margin-bottom: 0;
        }
    </style>
    </head>
    <body>
        
        <%
            ServletContext sctxt=super.getServletContext();
            String username=(String)sctxt.getAttribute("Username");
            String first_name=(String)sctxt.getAttribute("User_first_name");
            String last_name=(String)sctxt.getAttribute("User_last_name");
            %>
            <h1>WELCOME <%= username %> </h1>
            <h2>AKA: <%= first_name+" "+last_name%></h2><br><hr>
            <!-- CONTENT DISPLAY -->
             <h1>Select Blogs Genres</h1>
            <div id="genreButtons">
  <button onclick="navigateToPage('biography')">BIOGRAPHY</button>
 <button onclick="navigateToPage('fiction')"> Fiction</button>
  <button onclick="navigateToPage('technology')">TECHNOLOGY</button>
  <button onclick="navigateToPage('story')">STORY</button>
    <button onclick="navigateToPage('other')">SUB GENRE</button>
  <!-- Add more buttons as needed -->
</div>
<hr><hr>
            <h2>BLOGS:</h2>
            
             <div class="container">
        <h2>Genre</h2>
        <p id="genre">Placeholder Genre</p
        <br>
         <h2>Subgenre</h2>
        <p id="subgenre">Placeholder Subgenre</p>
        <br>
        <h2>Title</h2>
        <p id="title">Placeholder Title</p>
        <br>
        <h2>Content</h2>
        <p id="content">Placeholder Content</p>
    </div>
            



    <script>
        function navigateToPage(genre) {
  // Construct the JSP page URL based on the selected genre
  var jspPage = genre + ".jsp";
  
  // Redirect to the constructed JSP page
  window.location.href = jspPage;}
        // JavaScript code to update genre, title, and content
        window.onload = function() {
            // Get genre, title, and content from URL parameters
            const urlParams = new URLSearchParams(window.location.search);
            const genre = urlParams.get('genre');
            const subgenre = urlParams.get('subgenre');
            const title = urlParams.get('title');
            const content = urlParams.get('content');
               var gen="SCIENCE";
               var subgen="SPACE";
               var tit="WONDERS OF SPACE";
               var cont="hello world nice to meet you hope you are oky.";
            // Update genre, title, and content in the HTML
            document.getElementById("genre").textContent = genre || gen;
         document.getElementById("subgenre").textContent = subgenre || subgen;    
        document.getElementById("title").textContent = title || tit;
            document.getElementById("content").textContent = content || cont;
        };
    </script>
            
            
            
    </body>
</html>
