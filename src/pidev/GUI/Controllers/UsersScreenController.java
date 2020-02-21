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
import pidev.Entite.Users;
import pidev.GUI.Navigation;
import pidev.GUI.UserScreenController;
import pidev.Service.UserService;

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
    private TableView<Users> TableUsers;
    @FXML
    private TableColumn<Users, String> FnameUser;
    @FXML
    private TableColumn<Users, String> LnameUser;
    @FXML
    private TableColumn<Users, Integer> PhoneUser;
    @FXML
    private TableColumn<Users, String> EmailUser;
    @FXML
    private TableColumn<Users, Integer> StatutUser;
    @FXML
    private TableColumn<Users, Integer> IDUser;
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
     * initialises the controller class.
     */
    Navigation nav = new Navigation();
    ObservableList<Users> listUsers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }

    @FXML
    private void goHomeScreen(ActionEvent event) {
    }

    @FXML
    void goUsersScreen(ActionEvent event) {
        refresh();
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

    @FXML
    void changeStatutUser(ActionEvent event) {
        Integer a = Integer.parseInt( StatutUser.getText());
        if (a==0){
            setStatutUser(1);
        } else {
            setStatutUser(0);
        }
        refresh();
System.out.println(a);

    }

    @FXML
    void goCheckUserGroupScreen(ActionEvent event) throws IOException {
        nav.navigationCheckUserGroupScreen(event);
    }

    public void refresh() {
        UserService US = new UserService();
        listUsers.clear();
        try {
            listUsers.addAll(US.readAll());

        } catch (SQLException ex) {
            Logger.getLogger(UserScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        IDUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        FnameUser.setCellValueFactory(new PropertyValueFactory<>("fnameUser"));
        LnameUser.setCellValueFactory(new PropertyValueFactory<>("lnameUser"));
        PhoneUser.setCellValueFactory(new PropertyValueFactory<>("phoneUser"));
        EmailUser.setCellValueFactory(new PropertyValueFactory<>("emailUser"));
        StatutUser.setCellValueFactory(new PropertyValueFactory<>("statutUser"));
        TableUsers.setItems(listUsers);

        FilteredList<Users> filteredData = new FilteredList<>(listUsers, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Users user) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getFnameUser().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (user.getLnameUser().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (user.getEmailUser().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(user.getIdUser()).contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(user.getPhoneUser()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Users> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableUsers.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        TableUsers.setItems(sortedData);
    }

    public void setStatutUser(int StatutUser) {
        this.StatutUser.setText(String.valueOf(StatutUser));
            }

    
}
