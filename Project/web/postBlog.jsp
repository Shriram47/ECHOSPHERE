<%-- 
    Document   : postBlog
    Created on : May 8, 2024, 12:16:16 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COMPOSE BLOG</title>
         <style>
        input[type="text"],
        select,
        textarea {
            border: 1px solid #ccc; /* Add border to the input fields */
            border-radius: 5px; /* Makes the borders round */
            padding: 10px; /* Adds padding inside the input fields */
            width: calc(50% - 12px); /* Sets the width to half minus border and padding */
            font-size: 16px; /* Sets the font size */
            margin-bottom: 10px; /* Adds some spacing between the input fields */
            box-sizing: border-box; /* Include padding and border in the element's total width and height */
        }

        textarea {
            height: 200px; /* Sets a fixed height for the content textarea */
            resize: vertical; /* Allows vertical resizing */
            width: 1000px;
        }
        

        #wordCount {
            margin-top: 5px;
            font-size: 14px;
            color: #555;
        }

        input[type="submit"] {
            padding: 15px 30px; /* Increase padding to make the button bigger */
            font-size: 18px; /* Increase font size */
            border-radius: 5px; /* Makes the borders round */
            background-color: #007bff; /* Sets the background color */
            color: #fff; /* Sets the text color */
            border: none; /* Removes border */
            cursor: pointer; /* Changes cursor to pointer on hover */
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker background color on hover */
        }
    </style>
    </head>
    <body>
        <%  int counter=0;
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
       
           
           
        %>
                 <h2>COMPOSE BY: <%=username%></h2>
            <h3>NAME: <%=first_name+" "+last_name%></h3>
                       <h3>MAIL ID: <%=mailid%></h3><hr>
            
            
            
            <h1>WRITE BLOG:<br></h1>
            
           <form action="PostInsertion" method="post">
        <input type="text" id="title" name="title" placeholder="Title" required><br>
        <select id="genre" name="genre" required>
            <option value="" disabled selected>Select Genre</option>
            <option value="biography">Biography</option>
            <option value="story">Story</option>
            <option value="technology">Technology</option>
            <option value="fiction">Fiction</option>
            <option value="other">Other</option>
        </select><br>
        <input type="text" id="subgenre" name="subgenre" placeholder="Sub-genre" required><br>
        <textarea id="content" name="content" placeholder="Content" required></textarea><br>
        <span id="wordCount">Word count: 0</span><br><br>
        <input type="submit" value="Submit">
    </form>

    <script>
        const contentTextarea = document.getElementById('content');
        const wordCountSpan = document.getElementById('wordCount');

        contentTextarea.addEventListener('input', function() {
            const words = this.value.split(/\s+/).filter(word => word.trim() !== '');
            wordCountSpan.textContent = 'Word count: ' + words.length;
        });
    </script>
            
            
            
    
    </body>
</html>
