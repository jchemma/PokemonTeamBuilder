/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pokemon;
import util.DBUtil;

/**
 *
 * @author chemm
 */
public class Manager {

    //get team
    
    public static List<Pokemon> getTeam (int team_id)throws SQLException, ClassNotFoundException {
        List<Pokemon> team = new ArrayList<>();
       return new ArrayList<>();
       
    }
    
    public static void clearTeam(int team_id) throws SQLException, ClassNotFoundException{
        Connection connection = DBUtil.getConnection();
        Statement stmt = connection.createStatement();
        String sql;
        sql = "DELETE FROM `pokemon_team_builder`.`teams` WHERE `id`= "+team_id+";";
        stmt.executeUpdate(sql);
    }
    //add pokemon to the team
    public static void addToTeam(int pokemon_id, int slot, int team_id) throws SQLException, ClassNotFoundException{
        Connection connection = DBUtil.getConnection();
        Statement stmt = connection.createStatement();
        String sql;
        sql = "UPDATE `pokemon_team_builder`.`teams` SET `slot_"+slot+"`='"+pokemon_id+"' WHERE `id`='"+team_id+"';";
        stmt.executeUpdate(sql);
    }
    //take pokemon from team
    public static void removeFromTeam(int slot, int team_id) throws SQLException, ClassNotFoundException{
        Connection connection = DBUtil.getConnection();
        Statement stmt = connection.createStatement();
        String sql;
        sql = "UPDATE `pokemon_team_builder`.`teams` SET `slot_"+slot+"`=NULL WHERE `id`='"+team_id+"';";
        stmt.executeUpdate(sql);
    }
     //get all pokemon from database
     public static ObservableList<Pokemon> getDatabase() throws SQLException, ClassNotFoundException{
        ObservableList<Pokemon> database = FXCollections.observableArrayList();
         Statement stmt = null;
        Connection connection = DBUtil.getConnection();
        stmt = connection.createStatement();
        String sql = "SELECT pokemon.name AS Pokemon, t_name AS Type, abilities.name AS Ability\n"
                + "FROM ((((pokemon JOIN pokemon_types on pokemon.id = pokemon_types.pokemon_id) JOIN ((SELECT id as t_id, name as t_name FROM types) as t)\n"
                + "ON type_id= t.t_id) JOIN pokemon_abilities ON pokemon.id = pokemon_abilities.pokemon_id)\n"
                + "JOIN abilities ON ability_id = abilities.id)\n"
                + "GROUP BY pokemon.id;";
        ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(rs.getString("Pokemon"));
                pokemon.setType1(rs.getString("Type"));
                pokemon.setAbility(rs.getString("Ability"));
		database.add(pokemon);
            }
            connection.close();
            return database;
    }
    
    
}
