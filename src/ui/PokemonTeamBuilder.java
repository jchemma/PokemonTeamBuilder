/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Pokemon;

/**
 *
 * @author chemm
 */
public class PokemonTeamBuilder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            BorderPane borderPane = (BorderPane) FXMLLoader.load(PokemonTeamBuilder.class.getResource("PokemonTeamBuilder.fxml"));
            Scene scene  = new Scene(borderPane,1000, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Pokemon Team Builder");
            primaryStage.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}