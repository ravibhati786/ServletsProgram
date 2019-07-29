/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.*;
public class NewClass {
    
    public static void main(String args[]) throws Exception
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:LoginDB");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select * from UserMaster");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+ " " + rs.getString(2));
        }
        con.close();
    }
    
}
