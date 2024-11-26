package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {

	public void insertdata() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("INSERT INTO animal VALUES('lion','yellow')");
		c.close();
		System.out.println("Data inserted successfully......!!");

	}

	public void updatedata() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("UPDATE animal SET color = 'red' WHERE name = 'lion'");
		c.close();
		System.out.println("Data updated  successfully......!!");

	}

	public void deletetdata() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("delete from animal where name = 'cat'");
		c.close();
		System.out.println("Data deleted successfully......!!");

	}

	public void fetchdata() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		 var rs = s.executeQuery("select * from animal");
		 while (rs.next()) {
		        String name = rs.getString("name");
		        String color = rs.getString("color");
		        System.out.println("Animal: " + name + ", Color: " + color);
		    }
		c.close();

	}

	public static void main(String[] args) throws Exception {

		JdbcDemo1 d1 = new JdbcDemo1();
		d1.insertdata();
//		d1.updatedata();
//		d1.deletetdata();
//		d1.fetchdata();

	}

}
