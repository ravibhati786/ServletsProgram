//Write a SERVLET program to change inactive time interval of session.

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Slip3")
public class Slip3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		HttpSession session = request.getSession();
    		out.println("<h4>Session Timer</h4>");
    		out.println("The previous timeout was " +  session.getMaxInactiveInterval());
    		session.setMaxInactiveInterval(2*60*60);  // two hours
    		out.println("<br>The newly assigned timeout is " +  session.getMaxInactiveInterval());
	}


}
