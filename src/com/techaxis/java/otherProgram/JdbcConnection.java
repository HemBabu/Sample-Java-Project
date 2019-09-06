package com.techaxis.java.otherProgram;

import java.io.FileNotFoundException;
import java.sql.*;
public class JdbcConnection {
	static String url="jdbc:mysql://localhost:3306/student?useTimezone=true&serverTimezone=UTC";
	static String uname="root";
	static String upass="admin";
	static String query="select*from studentRecord";
public static void main(String[] args) throws FileNotFoundException,SQLException{
	Connection con=DriverManager.getConnection(url,uname,upass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);

	while(rs.next())
		System.out.println(rs.getShort("id"));

	con.close();
	
	
}
}

