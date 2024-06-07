package com.elhewazy.app;

import com.elhewazy.dao.UserDao;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("please enter your email ");
		Scanner sc = new Scanner(System.in);

		String email = sc.next();

		System.out.println("please enter your password ");
		String password = sc.next();
		UserDao ud = new UserDao();
		ud.getuser(email,password);
	}

}
