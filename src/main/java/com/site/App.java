package com.site;
import java.sql.*;


public class App 
{
    private static final String URL = "jdbc:mysql://localhost:3306/myapp";
    private static final String USER = "root";
    private static final String PASSWORD = "Sancho$123";

    public static void main(String[] args )
    {
        System.out.println( "connecting to Database" );
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Database Connected successfully");
        }
        catch (SQLException e) {
            System.out.println("Database connection failed!");
        }
    }
}
