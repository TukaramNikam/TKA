package com.tka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

    public void insertdata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
        Statement s = c.createStatement();
        s.executeUpdate("insert into fruit values ('apple','red')");
        System.out.println("Data inserted successfully..............");

        s.close();
    }

    public void updatedata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
        Statement s = c.createStatement();
        s.executeUpdate("UPDATE fruit SET color = 'yellow' WHERE name = 'orange'");
        System.out.println("Data updated successfully..............");

        s.close();
    }

    public void deletedata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
        Statement s = c.createStatement();
        s.executeUpdate("delete from fruit where name = 'orange'");
        System.out.println("Data deleted successfully..............");

        s.close();
    }

    public void fetchdata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
        Statement s = c.createStatement();
      
        ResultSet rs = s.executeQuery("SELECT * FROM fruit");
        
      
        while (rs.next()) {
            String name = rs.getString("name");
            String color = rs.getString("color");
            System.out.println("Animal: " + name + ", Color: " + color);
        }
        
        rs.close();
        s.close();
        c.close();
    }

    public static void main(String[] args) throws Exception {
       Demo1 d1 = new Demo1();
        d1.insertdata();
//        d1.updatedata();
//        d1.deletedata();
//        d1.fetchdata();
       
    }
}