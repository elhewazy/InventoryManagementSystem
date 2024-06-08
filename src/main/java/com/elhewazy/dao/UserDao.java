package com.elhewazy.dao;

import java.sql.*;

public class UserDao {

	public UserDao() {
	}

	public static Connection getConnectionUser() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/examDB";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		Class.forName("com.mysql.cj.jdbc.Driver");
		return conn;
	}

	public void adduser(String email,String password) throws SQLException, ClassNotFoundException {
String quiry ="insert into user (email,password) values(?,?)";
		PreparedStatement ps = getConnectionUser().prepareStatement(quiry);
		ps.setString(1,email);
		ps.setString(2,password);

		ps.execute();
		System.out.println("added successed");
	}

	public void getuser(String email,String password) throws SQLException, ClassNotFoundException {
		String quiry = "select * from user where email=? and password=?";
		PreparedStatement ps = getConnectionUser().prepareStatement(quiry);
		ps.setString(1,email);
		ps.setString(2,password);

		ResultSet rs = ps.executeQuery();
         rs.next();
		String emailDB = rs.getNString("email");
		System.out.println(emailDB);
		String passwordDB = rs.getNString("password");
		if (email.equals(emailDB) && password.equals(passwordDB)){
			// add code here
			System.out.println("you login successfully ");



		}
	}
}
