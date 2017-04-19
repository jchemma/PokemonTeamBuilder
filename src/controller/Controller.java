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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<Pokemon> table = new TableView<>();
    
    private TableColumn nameCol = new TableColumn("Name");
    private TableColumn abilityCol = new TableColumn("Ability");
    private TableColumn type1Col = new TableColumn("Type 1");
    private TableColumn hpCol = new TableColumn("HP");
    private TableColumn attackCol = new TableColumn("Attack");
    private TableColumn defenseCol = new TableColumn("Defense");
    private TableColumn speedCol = new TableColumn("Speed");
    private TableColumn specialAttackCol = new TableColumn("Special Attack");
    private TableColumn specialDefenseCol = new TableColumn("Special Defense");
    
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
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        abilityCol.setCellValueFactory(new PropertyValueFactory<>("ability"));
        type1Col.setCellValueFactory(new PropertyValueFactory<>("type1"));
        hpCol.setCellValueFactory(new PropertyValueFactory<>("hp"));
        speedCol.setCellValueFactory(new PropertyValueFactory<>("speed"));
        attackCol.setCellValueFactory(new PropertyValueFactory<>("attack"));
        defenseCol.setCellValueFactory(new PropertyValueFactory<>("defense"));
        specialAttackCol.setCellValueFactory(new PropertyValueFactory<>("specialAttack"));
        specialDefenseCol.setCellValueFactory(new PropertyValueFactory<>("specialDefense"));
        
        table.getColumns().setAll(nameCol,abilityCol,type1Col,hpCol,speedCol,attackCol,defenseCol,specialAttackCol,specialDefenseCol);
        getDatabase();
        
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
    
    public void getDatabase(){
        try{
            ObservableList<Pokemon> database = Manager.getDatabase();
            table.setItems(database);
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
