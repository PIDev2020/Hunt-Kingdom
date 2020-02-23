/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import pidev.Entite.CurrentUser;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class MainUController implements Initializable {

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
    private AnchorPane LoaderPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    ProfileUserScreenController  PUSC = new ProfileUserScreenController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadScreen();
        } catch (SQLException ex) {
            Logger.getLogger(MainUController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goHomeScreen(ActionEvent event) {
    }

    @FXML
    private void goUsersScreen(ActionEvent event) {
    }

    @FXML
    private void goGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void goProductsScreen(ActionEvent event) {
    }

    @FXML
    private void goOrdersScreen(ActionEvent event) {
    }

    @FXML
    private void goEventsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) {
    }

    public void loadScreen() throws SQLException {
AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("ProfileUserScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderPane.getChildren().setAll(pane);
    }
}
