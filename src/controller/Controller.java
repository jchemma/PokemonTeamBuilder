/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Manager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.Pokemon;

/**
 * FXML Controller class
 *
 * @author chemm
 */
public class Controller implements Initializable {

    @FXML
    private Pane pokemon_1;
    @FXML
    private Label pokemon_1_name;
    @FXML
    private Label pokemon_1_type1;
    @FXML
    private Label pokemon_1_type2;
    @FXML
    private Pane pokemon_2;
    @FXML
    private Label pokemon_2_name;
    @FXML
    private Label pokemon_2_type1;
    @FXML
    private Label pokemon_2_type2;
    @FXML
    private Pane pokemon_3;
    @FXML
    private Label pokemon_3_name;
    @FXML
    private Label pokemon_3_type1;
    @FXML
    private Label pokemon_3_type2;
    @FXML
    private Pane pokemon_4;
    @FXML
    private Label pokemon_4_name;
    @FXML
    private Label pokemon_4_type1;
    @FXML
    private Label pokemon_4_type2;
    @FXML
    private Pane pokemon_5;
    @FXML
    private Label pokemon_5_name;
    @FXML
    private Label pokemon_5_type1;
    @FXML
    private Label pokemon_5_type2;
    @FXML
    private Pane pokemon_6;
    @FXML
    private Label pokemon_6_name;
    @FXML
    private Label pokemon_6_type1;
    @FXML
    private Label pokemon_6_type2;
    @FXML
    private Button clear_button;
    
    private final String DEFAULT_NAME = "Unown";
    private final String DEFAULT_TYPE1 = "Psychic";
    private final String DEFAULT_TYPE2 = "";

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        getTeam(1);
        clear_button.setOnAction((ActionEvent event) -> {
            //clear pokemon labels
            pokemon_1_name.setText(DEFAULT_NAME);
            pokemon_2_name.setText(DEFAULT_NAME);
            pokemon_3_name.setText(DEFAULT_NAME);
            pokemon_4_name.setText(DEFAULT_NAME);
            pokemon_5_name.setText(DEFAULT_NAME);
            pokemon_6_name.setText(DEFAULT_NAME);
            
            pokemon_1_type1.setText(DEFAULT_TYPE1);
            pokemon_2_type1.setText(DEFAULT_TYPE1);
            pokemon_3_type1.setText(DEFAULT_TYPE1);
            pokemon_4_type1.setText(DEFAULT_TYPE1);
            pokemon_5_type1.setText(DEFAULT_TYPE1);
            pokemon_6_type1.setText(DEFAULT_TYPE1);
            
            pokemon_1_type2.setText(DEFAULT_TYPE2);
            pokemon_2_type2.setText(DEFAULT_TYPE2);
            pokemon_3_type2.setText(DEFAULT_TYPE2);
            pokemon_4_type2.setText(DEFAULT_TYPE2);
            pokemon_5_type2.setText(DEFAULT_TYPE2);
            pokemon_6_type2.setText(DEFAULT_TYPE2);
            
            //clear pokemon team from database
            clearTeam(1);
        });
    }
    
    private void clearTeam(int id){
        Manager.clearTeam(id);
    }

    private void getTeam(int i) {
        
        List<Pokemon> team = new ArrayList();
        
        try{
            team = Manager.getTeam("1");
        }catch(ClassNotFoundException | SQLException cnfe){
            cnfe.printStackTrace();
        }
        
        pokemon_1_name.setText(team.get(1).getName());
        pokemon_2_name.setText(team.get(2).getName());
        pokemon_3_name.setText(team.get(3).getName());
        pokemon_4_name.setText(team.get(4).getName());
        pokemon_5_name.setText(team.get(5).getName());
        pokemon_6_name.setText(team.get(6).getName());

        pokemon_1_type1.setText(team.get(1).getType1());
        pokemon_2_type1.setText(team.get(2).getType1());
        pokemon_3_type1.setText(team.get(3).getType1());
        pokemon_4_type1.setText(team.get(4).getType1());
        pokemon_5_type1.setText(team.get(5).getType1());
        pokemon_6_type1.setText(team.get(6).getType1());

        pokemon_1_type2.setText(team.get(1).getType2());
        pokemon_2_type2.setText(team.get(2).getType2());
        pokemon_3_type2.setText(team.get(3).getType2());
        pokemon_4_type2.setText(team.get(4).getType2());
        pokemon_5_type2.setText(team.get(5).getType2());
        pokemon_6_type2.setText(team.get(6).getType2());
    }
    
    
    
}
