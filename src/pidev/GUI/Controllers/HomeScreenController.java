/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import pidev.GUI.Navigation;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class HomeScreenController implements Initializable {

    @FXML
    private Label FirstNameLabel;
    @FXML
    private Label LastNameLabel;
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
    @FXML
    private Pane pnlOverview;
    @FXML
    private Button UsersButton;
    @FXML
    private Button GroupsButton;
    @FXML
    private Button ProductsButton;
    @FXML
    private Button OrdersButton;
    @FXML
    private Button EventsButton;
    @FXML
    private Button AnnoncesButton;

    /**
     * Initializes the controller class.
     */
    Navigation nav = new Navigation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            }    

    @FXML
    void goHomeScreen(ActionEvent event) {
    }

    @FXML
    void goUsersScreen(ActionEvent event) throws IOException {
                nav.navigateUserScreen(event);
    }

    @FXML
    void goGroupsScreen(ActionEvent event) throws IOException {
        nav.navigateGroupScreen(event);
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

    @FXML
    private void signOut(ActionEvent event) {
    }
    
}
