/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chemm
 */
public class DBUtil {
    private DBUtil(){
        
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mysql.JDBC");
        Connection connection = null;
        
        String projectDirectory = System.getProperty("user.dir");
        connection = DriverManager.getConnection("jdbc:mysql: " + projectDirectory +"/pokemon_team_builder","","");
        return connection;
    }
}
