/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
          Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("UserPanier.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("TableAnimal.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("TableCommande.fxml"));
        
        Scene scene=new Scene (root);
        primaryStage.setTitle("javaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
