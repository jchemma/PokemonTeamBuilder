/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pokemon;
import util.DBUtil;

/**
 *
 * @author chemm
 */
public class Manager {

    //get team

    public static List<Pokemon> getTeam (String team_id)throws SQLException, ClassNotFoundException {
        List<Pokemon> team = new ArrayList<>();
         Statement stmt = null;
        Connection connection = DBUtil.getConnection();
        stmt = connection.createStatement();
        String sql = "SELECT pokemon.name AS Pokemon, types.name AS Type, abilities.name as Ability\n" +
            " FROM ((((pokemon JOIN pokemon_types ON pokemon.id = pokemon_types.pokemon_id)JOIN types "+
            "ON type_id = types.id)JOIN pokemon_abilities ON pokemon.id = pokemon_abilities.pokemon_id)"+
            "JOIN abilities ON ability_id = abilities.id)\n" +
            " GROUP BY pokemon.id;";
        ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(rs.getString("Pokemon"));
		pokemon.setType1(rs.getString("Type"));
		team.add(pokemon);
            }
            connection.close();
            return team;
    }
    //add pokemon to the team
     private static final String SQL_INSERT = "INSERT INTO `pokemon_team_builder`.`teams` (`id`, `name`, `slot_1`, `slot_2`, `slot_3`, `slot_4`, `slot_5`, `slot_6`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?')";
    //take pokemon from team
    
    
    
}
