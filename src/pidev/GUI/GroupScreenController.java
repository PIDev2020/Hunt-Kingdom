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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Groups;
import pidev.Entite.Users;
import pidev.Service.GroupService;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class GroupScreenController implements Initializable {

    @FXML
    private TableView<Groups> Table;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> MemberGroup;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button AddButton;

    /**
     * Initializes the controller class.
     */
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 1. fill in the table view
        GroupService GS = new GroupService();
        try {
            listGroups.addAll(GS.readAll());
        } catch (SQLException e) {
            Logger.getLogger(UserScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        IDGroup.setCellValueFactory(new PropertyValueFactory<>("idGroup"));
        NameGroup.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
        TypeGroup.setCellValueFactory(new PropertyValueFactory<>("typeGroup"));
        Table.setItems(listGroups);

        // 2. search bar 
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
        sortedData.comparatorProperty().bind(Table.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        Table.setItems(sortedData);
    }

    @FXML
    void deleteGroup(ActionEvent event) throws SQLException {
        UserService US = new UserService();
        US.delete(IDGroup.getCellData(Table.getSelectionModel().getSelectedIndex()));
        JOptionPane.showMessageDialog(null, "Group Deleted");
        Table.refresh();
    }

    @FXML
    void updateGroup(ActionEvent event) {
    }

    @FXML
    void addGroup(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddGroupScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Add User");
        stage.setScene(new Scene(root1));
        stage.show();
    }

}