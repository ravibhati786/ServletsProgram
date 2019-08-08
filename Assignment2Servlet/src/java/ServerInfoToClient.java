/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lacs.lab
 */
@WebServlet(urlPatterns = {"/ServerInfoToClient"})
public class ServerInfoToClient extends HttpServlet {

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServerInfoToClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Server Information </h1>");
            out.println("<h3>Server Name = "+request.getServerName()+"</h1>");
            out.println("<h3>Server Port = "+request.getServerPort()+"</h1>");
            out.println("<h3>Server Path = "+request.getServletPath()+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  

}
