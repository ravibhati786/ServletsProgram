/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(urlPatterns = {"/searchServlet"})
public class searchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("txtID"));
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:LoginDB");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * from rv where ID="+id);
            
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            if(count > 0)
                out.println("<h1>The Record Exists!</h1>");
            else
                out.println("<h1>The Record Doesn't Exists!</h1>");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
    }
}
