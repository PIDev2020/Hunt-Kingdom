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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pidev.Entite.Groups;
import pidev.GUI.Navigation;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class GroupScreenController implements Initializable {

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
    private TableView<Groups> TableGroups;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button ShowUsersGroupButton;
    @FXML
    private Button addButton;
    @FXML
    private Label LastNameLabel;
    @FXML
    private Label FirstNameLabel;

    /**
     * initialises the controller class.
     *
     * @param url
     * @param rb
     */
    Navigation nav = new Navigation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goHomeScreen(ActionEvent event) {
    }

    @FXML
    void goUsersScreen(ActionEvent event) throws IOException {
        nav.navigateUserScreen(event);
    }

    @FXML
    void goGroupsScreen(ActionEvent event) throws IOException {
        refresh();
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
    void ShowUsersGroup(ActionEvent event) throws IOException {
        nav.navigationCheckGroupUserScreen(event);
    }

    @FXML
    void addGroup(ActionEvent event) throws IOException {
        nav.navigationAddGroupScreen(event);
    }

    public void refresh() {

    }
}
