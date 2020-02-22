/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class MainScreenController implements Initializable {

    @FXML
    private AnchorPane LoaderAnchorPane;
    @FXML
    private Button HomeButton;
    @FXML
    private Button UserButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button OrderButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane paneI = null;
        try {
            paneI = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(paneI);

    }

    @FXML
    void goHomeScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goUsersScreen(ActionEvent event) throws IOException {
      AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("UsersScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    void goGroupsScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("GroupScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
void goProductsScreen(ActionEvent event) {
//        AnchorPane pane = null;
//        try {
//            pane = FXMLLoader.load(getClass().getResource("FXML/HomeScreen"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
  void goOrdersScreen(ActionEvent event) {
//        AnchorPane pane = null;
//        try {
//            pane = FXMLLoader.load(getClass().getResource("FXML/HomeScreen"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goEventsScreen(ActionEvent event) {
//        AnchorPane pane = null;
//        try {
//            pane = FXMLLoader.load(getClass().getResource("FXML/HomeScreen"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goAnnoncesScreen(ActionEvent event) {
//        AnchorPane pane = null;
//        try {
//            pane = FXMLLoader.load(getClass().getResource("FXML/HomeScreen"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void signOut(ActionEvent event) {
    }

}
