
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;


@WebServlet(urlPatterns = {"/insertServlet"})
public class insertServlet extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int roll = Integer.parseInt(request.getParameter("txtNum"));
        String name = request.getParameter("txtName");
        PrintWriter out = response.getWriter();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:LoginDB");
            PreparedStatement pst = con.prepareStatement("insert into Student values(?,?)");
            pst.setInt(1,roll);
            pst.setString(2,name);
            
            pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
