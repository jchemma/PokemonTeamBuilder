/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;

/**
 *
 * @author chemm
 */
public class DBUtil {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/pokemon_team_builder";
   static final String USER = "root";
   static final String PASS = "root@localhost";
    private DBUtil(){
        
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement stmt = null;
        try{
        //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(SQLException se){
        //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
        //Handle errors for Class.forName
            e.printStackTrace();
        }
        return connection;
    }
}
