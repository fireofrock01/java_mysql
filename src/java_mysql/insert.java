package java_mysql;

import java.sql.*;
import java.util.Scanner;

public class insert {

    public static void main(String[] args) {
        String id,name,email,coun;
        double budget,used; 
        Scanner reader = new Scanner(System.in);
        
        System.out.print("ID");
        id =reader.nextLine();
        System.out.print("Name");
        name =reader.nextLine();
        System.out.print("email");
        email =reader.nextLine();
        System.out.print("country");
        coun =reader.nextLine();
        System.out.print("budget");
        budget =reader.nextDouble();
        System.out.print("used");
        used =reader.nextDouble();
        
        Connection connect = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/hatsawat"
                    + "?user=root&password=root");

            s = connect.createStatement();

            String sql = "INSERT INTO customer "
                    + "(CustomerID,Name,Email,CountryCode,Budget,Used) "
                    + "VALUES ('"+id+"','"+name+"','"+email+"','"+coun+"','"+budget+"','"+used+" ') ";
                     
            s.execute(sql);

            System.out.println("Record Inserted Successfully");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if (connect != null) {
                s.close();
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
