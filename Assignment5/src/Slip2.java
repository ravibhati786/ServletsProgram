/*
 Write a SERVLET application to accept username and password, search
them into database, if found then display appropriate message on the
browser otherwise display error message.

 */
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Slip2")
public class Slip2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:LoginDB");
			PreparedStatement pstm = con.prepareStatement("select * from UserMaster where UserName =? and Password =?");
			pstm.setString(1, request.getParameter("txtUserName"));
			pstm.setString(2, request.getParameter("txtPassword"));
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next())
			{
				String username = rs.getString(1);
				String pass = rs.getString(2);
				
				if(request.getParameter("txtUserName").equals(username) && request.getParameter("txtPassword").equals(pass))
				{
					pw.println("<h4> Welcome "+username+" </h4>");
				}
				else{
					pw.println("<h5> Incorrect Credentials!");
				}
			}
			else
			{
				pw.println("<h5> Incorrect Credentials!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
