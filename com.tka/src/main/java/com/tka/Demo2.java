package com.tka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo2 {

    public void insertdata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

        String query = "INSERT INTO fruit (name, color) VALUES (?, ?)";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, "orange");  
        ps.setString(2, "orange");  
        
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("Data inserted successfully..............");
        }

        ps.close();
        c.close();
    }

    public void updatedata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

        String query = "UPDATE fruit SET color = ? WHERE name = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, "yellow");  
        ps.setString(2, "orange");  
        
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("Data updated successfully..............");
        }

        ps.close();
        c.close();
    }

    public void deletedata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

        String query = "DELETE FROM fruit WHERE name = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, "orange");  
        
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("Data deleted successfully..............");
        }

        ps.close();
        c.close();
    }

    public void fetchdata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

        String query = "SELECT * FROM fruit";
        PreparedStatement ps = c.prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            String name = rs.getString("name");
            String color = rs.getString("color");
            System.out.println("Fruit: " + name + ", Color: " + color);
        }
        
        rs.close();
        ps.close();
        c.close();
    }

    public static void main(String[] args) throws Exception {
        Demo2 d1 = new Demo2 ();
        //d1.insertdata();
        //d1.updatedata();
        //d1.deletedata();
        d1.fetchdata();
    }
}