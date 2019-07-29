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
@WebServlet(urlPatterns = {"/VoteEligible"})
public class VoteEligible extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int age = Integer.parseInt(request.getParameter("txtAge"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VoteEligible</title>");            
            out.println("</head>");
            out.println("<body>");
            if(age>=18)
                out.println("<h1>"+request.getParameter("txtName") + " You are Eligible for Voting " + "</h1>");
            else
                out.println("<h1>"+request.getParameter("txtName") + " You are not Eligible for Voting " + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


}
