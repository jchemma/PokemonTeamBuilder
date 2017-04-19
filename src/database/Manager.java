/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Pokemon;
import model.Team;

/**
 *
 * @author chemm
 */
public class Manager {
    
    //get team
    
    public static List<Pokemon> loadTeam(){
        
        List<Pokemon> team = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = DBUtil.getConnection();
        }
    }
    
    //add pokemon to the team
    
    //take pokemon from team
    
    
    
}
