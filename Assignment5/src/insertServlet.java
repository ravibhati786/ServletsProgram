
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	int roll = Integer.parseInt(request.getParameter("txtNum"));
    	String name = request.getParameter("txtName");
    	try{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	Connection con = DriverManager.getConnection("jdbc:odbc:LoginDB");
        	PreparedStatement stm = con.prepareStatement("Insert into Student values(?,?)");
        	
        	stm.setInt(1, roll);
        	stm.setString(2, name);
        	
        	int result = stm.executeUpdate();
        	
        	if(result > 0)
        	{
        		pw.println("Successfully Inserted!");
        	}
        	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
	}

	
}
