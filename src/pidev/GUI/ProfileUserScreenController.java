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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.Entite.Groups;
import pidev.Entite.Users;
import pidev.Entite.CurrentUser;
import pidev.Service.GroupService;
import static sun.rmi.registry.RegistryImpl.getID;

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
    int id;
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
    GroupService GS = new GroupService();

    /**
     * Initializes the controller class.
     * @param id 
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            load();
//        System.out.println(id);
//        listGroups.clear();
//        try {
//            listGroups.addAll(GS.readAll(id));
//        } catch (SQLException ex) {
//            Logger.getLogger(ProfileUserScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        IDGroup.setCellValueFactory(new PropertyValueFactory<>("idGroup"));
//        NameGroup.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
//        TypeGroup.setCellValueFactory(new PropertyValueFactory<>("typeGroup"));
//        TableGroups.setItems(listGroups);
//        FilteredList<Groups> filteredData = new FilteredList<>(listGroups, lu -> true);
//        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Groups group) -> {
//                // 2.1. If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                // 2.2. Compare id name and type of every group with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//                if (group.getNameGroup().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // 2.2.1. Filter matches  name.
//                } else if (group.getTypeGroup().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // 2.2.2. Filter matches type.
//                } else if (String.valueOf(group.getIdGroup()).contains(lowerCaseFilter)) {
//                    return true; // 2.2.3. Filter matches id
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
//        //3. sorted list
//        // 3.1. Wrap the FilteredList in a SortedList. 
//        SortedList<Groups> sortedData = new SortedList<>(filteredData);
//
//        // 3.2. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(TableGroups.comparatorProperty());
//
//        // 3.3. Add sorted (and filtered) data to the table.
//        TableGroups.setItems(sortedData);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load() throws SQLException {

        listGroups.clear();
        listGroups.addAll(GS.readAll(id));
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

    @FXML
    private void goUpdateProfileScreen(ActionEvent event) {
    }

    @FXML
    private void goMyGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void signOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        stage.show();
        final Node source = (Node) event.getSource();
        final Stage stages = (Stage) source.getScene().getWindow();
        stages.close();
    }

    @FXML
    private void deleteAccount(ActionEvent event) {
    }

    @FXML
    private void ShowUsersGroup(ActionEvent event) {
    }

}
