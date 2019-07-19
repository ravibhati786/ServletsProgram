/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Write a servlet that will count the number of times a client has accessed the web page.

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
@WebServlet(urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    private int hitCount;
    public void init()
    {
        hitCount = 0;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        hitCount++;
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>\n"+
                "<head><title> Hit Counter </title> </head>\n"+
                "<body>\n"+
                "<h1 align=center> Total Number of Hits </h1> <h3 align=center> "+hitCount+"</h3>"+
                "</body> </html>"
                );
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
}
