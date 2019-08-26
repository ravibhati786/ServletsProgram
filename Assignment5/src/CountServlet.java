/*
	Write a Servlet program to count the number of times a servlet has been invoked using Cookies.
*/


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		boolean flag = false;
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null)
		{
			for(int i=0; i<cookies.length; i++)
			{
				if(cookies[i].getName().equals("Counter"))
				{
					int count = Integer.parseInt(cookies[i].getValue());
					count++;
					
					cookies[i].setMaxAge(0); // delete existing cookie
					
					// add cookie with new counter value
					
					Cookie ck = new Cookie("Counter", Integer.toString(count));
					res.addCookie(ck);
					
					pw.println("You have visited this Page for "+count+" times.");
						
					flag = true;
					
					break;
				}
			}
		} //end for
		if(flag == false)
		{
			Cookie ck = new Cookie("Counter","1");
			res.addCookie(ck);
			pw.println("Welcome!! ");
		}
		
		
	}
    
	

}
