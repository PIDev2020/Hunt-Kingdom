/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

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
import javafx.scene.layout.AnchorPane;
import pidev.Entite.Groups;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class ProfileUserScreenController implements Initializable {

    @FXML
    private AnchorPane LoaderAnchorPane;
    @FXML
    private TableView<Groups> TableGroups;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private Button ShowUsersGroupButton;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Label FirstName;
    @FXML
    private Label LastName;
    @FXML
    private Label Email;
    @FXML
    private Label Phone;
    @FXML
    private Button UpdateProfileButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowUsersGroup(ActionEvent event) {
    }

    @FXML
    private void goUpdateProfileScreen(ActionEvent event) {
    }

    @FXML
    private void goMyGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void signOut(ActionEvent event) {
    }

    @FXML
    private void deleteAccount(ActionEvent event) {
    }
    
}
