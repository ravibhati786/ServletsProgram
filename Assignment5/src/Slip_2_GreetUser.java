/*
 	Write a servlet to display a message to the user depending on the Current Date.
 */

import java.io.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Slip_2_GreetUser")
public class Slip_2_GreetUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		Date d = new Date();
		
		pw.println("<h2>Today is "+ d+"</h2>");
		int hrs = d.getHours();
		
		if(hrs<=12)
			pw.println("<h2>Good Morning!</h2>");
		else if(hrs>12 && hrs<=17)
			pw.println("<h2>Good AfterNoon!</h2>");
		else if(hrs>17 && hrs<=20)
			pw.println("<h2>Good Evening!</h2>");
		else
			pw.println("<h2>Good Night!</h2>");
		
		
		
	}
	

}
