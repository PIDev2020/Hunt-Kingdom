/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import pidev.Entite.Groups;
import pidev.GUI.Navigation;
import pidev.GUI.Controllers.UsersScreenController;
import pidev.Service.GroupService;

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
    
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
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
        GroupService GS = new GroupService();
        listGroups.clear();
        try {
            listGroups.addAll(GS.readAll());
        } catch (SQLException e) {
            Logger.getLogger(UsersScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        IDGroup.setCellValueFactory(new PropertyValueFactory<>("idGroup"));
        NameGroup.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
        TypeGroup.setCellValueFactory(new PropertyValueFactory<>("typeGroup"));
        TableGroups.setItems(listGroups);
        FilteredList<Groups> filteredData = new FilteredList<>(listGroups, lu -> true);
        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Groups group) -> {
                // 2.1. If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // 2.2. Compare id name and type of every group with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (group.getNameGroup().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // 2.2.1. Filter matches  name.
                } else if (group.getTypeGroup().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // 2.2.2. Filter matches type.
                } else if (String.valueOf(group.getIdGroup()).contains(lowerCaseFilter)) {
                    return true; // 2.2.3. Filter matches id
                } else {
                    return false; // Does not match.
                }
            });
        });
        //3. sorted list
        // 3.1. Wrap the FilteredList in a SortedList. 
        SortedList<Groups> sortedData = new SortedList<>(filteredData);

        // 3.2. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableGroups.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        TableGroups.setItems(sortedData);

    }
}
