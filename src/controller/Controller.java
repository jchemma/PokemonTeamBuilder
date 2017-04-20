/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
    TODO
1. Add Pokemon to team on click
    a. get clicked pokemon
    b. check if room
        a. if room: add to team in database and change values in open slot
        b. send error message
    
2. Remove pokemon from team on click
3. View Saved teams
4. Display Stats
5. 
*/
package controller;

import model.Team;
import database.Manager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Pokemon;
import model.Team;

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
    private Button save;
    @FXML
    private Button get_team;
    @FXML
    private TableView<Pokemon> table = new TableView<>();
    
    private TableColumn idCol = new TableColumn("ID");
    private TableColumn nameCol = new TableColumn("Name");
    private TableColumn abilityCol = new TableColumn("Ability");
    private TableColumn type1Col = new TableColumn("Type");
    private TableColumn hpCol = new TableColumn("HP");
    private TableColumn speedCol = new TableColumn("Speed");
    private TableColumn attackCol = new TableColumn("Attack");
    private TableColumn defenseCol = new TableColumn("Defense");
    private TableColumn specialAttackCol = new TableColumn("Special Attack");
    private TableColumn specialDefenseCol = new TableColumn("Special Defense");
    
    private final String DEFAULT_NAME = "";
    private final String DEFAULT_TYPE1 = "";
    private final String DEFAULT_TYPE2 = "";
    
    private Team team;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //sets columns on initialize
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        abilityCol.setCellValueFactory(new PropertyValueFactory<>("ability"));
        type1Col.setCellValueFactory(new PropertyValueFactory<>("type1"));
        
        table.getColumns().setAll(idCol,nameCol,abilityCol,type1Col,hpCol,speedCol,attackCol,defenseCol,specialAttackCol,specialDefenseCol);
        getDatabase();
        
        try{
            team = Manager.getTeam(1);
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            team = new Team();
        }
        
        //add a click listener to each list item
        table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Pokemon>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Pokemon> c) {
                for (Pokemon p : c.getList()) {
                    if(team.size() >= 6){
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("TOO FULL");
                        alert.setHeaderText("Team Is Too Full");
                        alert.setContentText("Please remove pokemon before adding any more.");
                        alert.showAndWait();
                    }else{
                        System.out.println(p.getName());
                        System.out.println(p.getID());
                        int num = team.size();
                        System.out.println(team.size());
                        switch(num){
                            case 0:
                                team.add(p);
                                System.out.println(team.getTeam().get(0).getID());
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            case 1:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            case 2:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;    
                            case 3:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            case 4:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            case 5:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            case 6:
                                team.add(p);
                                pokemon_1_name = new Label();
                                pokemon_1_name.textProperty().bind(p.nameProperty());
                                break;
                            default:
                                System.out.println("Fail");
                        }
                    }
                }
            }
        });
        
        save.setOnAction((ActionEvent event) -> {
            try{
                Manager.saveTeam(team.getTeamID(), team.getTeam());
            }catch(SQLException | ClassNotFoundException e){
                System.out.println("Saving failed");
                e.printStackTrace();
            }
        });
        
        clear_button.setOnAction((ActionEvent event) -> {
            //clear pokemon labels
//            pokemon_1_name.setText(DEFAULT_NAME);
//            pokemon_2_name.setText(DEFAULT_NAME);
//            pokemon_3_name.setText(DEFAULT_NAME);
//            pokemon_4_name.setText(DEFAULT_NAME);
//            pokemon_5_name.setText(DEFAULT_NAME);
//            pokemon_6_name.setText(DEFAULT_NAME);
//            
//            pokemon_1_type1.setText(DEFAULT_TYPE1);
//            pokemon_2_type1.setText(DEFAULT_TYPE1);
//            pokemon_3_type1.setText(DEFAULT_TYPE1);
//            pokemon_4_type1.setText(DEFAULT_TYPE1);
//            pokemon_5_type1.setText(DEFAULT_TYPE1);
//            pokemon_6_type1.setText(DEFAULT_TYPE1);
//            
//            pokemon_1_type2.setText(DEFAULT_TYPE2);
//            pokemon_2_type2.setText(DEFAULT_TYPE2);
//            pokemon_3_type2.setText(DEFAULT_TYPE2);
//            pokemon_4_type2.setText(DEFAULT_TYPE2);
//            pokemon_5_type2.setText(DEFAULT_TYPE2);
//            pokemon_6_type2.setText(DEFAULT_TYPE2);
            
            clearTeam(team.getTeamID());
        });
    }
    
    private void clearTeam(int id){
        try{
            Manager.clearTeam(id);
            team = new Team();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
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
