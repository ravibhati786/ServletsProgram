/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
  Write a Servlet which counts how many times a user has visited a web page. if the user is visiting the page for the first time,
    display a welcome message. if the user is revisiting the page, display the number of times visited. (Use Cookies)
 */
@WebServlet(urlPatterns = {"/UserVisitCookie"})
public class UserVisitCookie extends HttpServlet {
    int count;
    public void init()
    {
        count =0;
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Cookie ck[] = request.getCookies();
        
        String userName = request.getParameter("txtName");
        if(ck != null)
        {
        for(int i=0; i<=ck.length; i++)
        {
            if((ck[i].getName()).equals(userName))
            {
                count = Integer.parseInt(ck[i].getValue());
            }
        }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserVisitCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            if(count == 0)
                out.println("<h1> Welcome "+request.getParameter("txtName"));
            else
                out.println("<h1>" + request.getParameter("txtName")+ ", You have visited "+count+" times. </h1>");
            count++;
            Cookie c = new Cookie(userName,String.valueOf(count));
            out.println("</body>");
            out.println("</html>");
        }
    }

    

}
