/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demrar;

import Entity.Discount;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ruhic
 */
public class DBConnectivity {
    
    private Discount discount = new Discount(getTotalPrice(), getDiscountType());
    private static Connection conn = null;
    public static Statement stm;
    public static ResultSet resultSet = null;
    
    public static Connection getConnection() {
        
        if (new File("Garits_database.db").isFile()){ //Connecting to SQLite creates a new blank DB file if it does not exist so this check is important.
            String url = "jdbc:sqlite:Garits_database.db";

            try {
                if (conn == null){
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(url);
                    System.out.println("Created new DB connection");
                    return conn;
                }
            }
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Failed creating connection to database");
                //e.printStackTrace();
            }
            System.out.println("Database already connected");
            return conn;
            
        }
        else {
            
            System.out.println("Garits_database.db is missing. Please place this file inside 'Dem.rar' folder.");
        }
        return null;
    }
    public static void disconnect(Connection connection) {
        
        try {

            if (connection != null) {

                connection.close();
                System.out.println("Disconnected from the database.");
                conn = null;
            }
        }
        catch (SQLException ex) {

            System.out.println("Failed closing connection to database");
            System.out.println(ex.getMessage());
        }
    }
    
    public static Statement getStatement (){
        return stm;
    }
    
    public static ResultSet getResultSet(){
        return resultSet;
    }
    
    public static double getTotalPrice(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Garits_database.db");
            //System.out.println("Database is showin");
            
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT amount FROM Invoice");
            
            return resultSet.getDouble(1); // returns the Total Price at column 1
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not supported yet please wait."); 
    }
    
    public String getDiscountType(){
       try {
            conn = DriverManager.getConnection("jdbc:sqlite:Garits_database.db");
            //System.out.println("Database is showin");
            
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT discounttype FROM Customer");
            
            return resultSet.getString(1); // returns the Total Price at column 1
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not supported yet please wait."); 
     
    }
    
    public Date displayDate(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Garits_database.db");
            //System.out.println("Database is showin");
            
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT date FROM Invoice");
            
            return resultSet.getDate(1); // returns the Total Price at column 1
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not supported yet please wait."); 
     
    }
    
    public static Date getCurrentDate(){
        return new java.util.Date();
    }
    
    public String getRegNo(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Garits_database.db");
            //System.out.println("Database is showin");
            
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT regNo FROM Vehicle WHERE Firstname="+ getFirstName() );
            
            return resultSet.getString(1); // returns the Total Price at column 1
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not supported yet please wait."); 
     
    }
    
    public String getFirstName(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Garits_database.db");
            //System.out.println("Database is showin");
            
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT Firstname FROM Vehicle");
            
            return resultSet.getString(1); // returns the Total Price at column 1
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not supported yet please wait."); 
     
    }
   
    
    }

