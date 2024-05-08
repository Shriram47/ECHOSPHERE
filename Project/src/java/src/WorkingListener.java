/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package src;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
<servlet>
        <servlet-name>MyListener</servlet-name>
        <servlet-class>src.MyListener</servlet-class>
    </servlet>
    
<servlet-mapping>
        <servlet-name>MyListener</servlet-name>
        <url-pattern>/MyListener</url-pattern>
    </servlet-mapping>
 */
public class WorkingListener implements ServletContextListener {

   Connection con;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    
        System.out.println("\n\n\n\t ContextInitialized mthod run!!(WORKING_LISTENER)\n\n");
        ServletContext sctxt=sce.getServletContext();
        try{
            Class.forName(sctxt.getInitParameter("driver"));
            System.out.println("Driver class loaded");
            String url=sctxt.getInitParameter("url");
            String username=sctxt.getInitParameter("username");
            String password=sctxt.getInitParameter("password");
            System.out.println("URL:"+url+"\nUSERNAME: "+username+"\nPassword: "+password);
             con=DriverManager.getConnection(url,username,password);
             sctxt.setAttribute("CONNECTION",(Connection)con);
             System.out.println("Connection object ready to shared");
             
        
        }
        
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver class not found!!: "+ex);
        }
        catch(SQLException ex)
        {
            System.out.println("SQL EXCEPTION OCCURE (WORKING LISTENER) :"+ex);
        }
        finally
        {
            System.out.println("FINALY BLOCK IS RUNN");
        }
    
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("CONTENT DESTRIYED BODY IS RUNNING(WORKING LISTENER)");
         try{
        if(con!=null)
            con.close();
            System.out.println("Succefully close connection");
        }
        catch(SQLException ex)
        {
        System.out.println("SQL Exception occured: "+ex.getMessage());}
  
    }

}
