/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("txtName");
            String pass = request.getParameter("txtPass");
            
            
            RequestDispatcher rd;
            if(user.equals("ravibhati786") && pass.equals("jerry"))
            {
                rd = request.getRequestDispatcher("WelcomeLogin");
                rd.forward(request, response);
            }
            else
            {
                out.print("Sorry Username or Password is Wrong.");
                rd = request.getRequestDispatcher("/LoginPage.html");
                rd.include(request, response);
            }     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
