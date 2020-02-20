/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UsersScreenController implements Initializable {

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
    private TableView<?> TableUsers;
    @FXML
    private TableColumn<?, ?> FnameUser;
    @FXML
    private TableColumn<?, ?> LnameUser;
    @FXML
    private TableColumn<?, ?> PhoneUser;
    @FXML
    private TableColumn<?, ?> EmailUser;
    @FXML
    private TableColumn<?, ?> StatutUser;
    @FXML
    private TableColumn<?, ?> IDUser;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button ChangeButton;
    @FXML
    private Button CheckButton;
    @FXML
    private Label LastNameLabel;
    @FXML
    private Label FirstNameLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void signOut(ActionEvent event) {
    }

    @FXML
    private void changeStatutUser(ActionEvent event) {
    }

    @FXML
    private void goCheckUserGroupScreen(ActionEvent event) {
    }
    
}
