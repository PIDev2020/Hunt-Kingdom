/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import pidev.Entite.Groups;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pidev.DataBase.DataBase;
import pidev.Entite.Users;

public class CheckUserGroupScreenController implements Initializable {

    @FXML
    private Label IDUser;
    @FXML
    private TableView<Groups> TableGroup;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private TextField SearchTermTextFiled;

    /**
     * initialises the controller class.
     *
     * @param IDUser
     */
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
  ObservableList<Users> listUsers = FXCollections.observableArrayList();
        private final Connection connexion;
    private Statement state;
    List<Groups> arrayGroup = new ArrayList<>();
    public CheckUserGroupScreenController() {
        connexion = DataBase.getInstance().getConnection();
    }
    

    public void setIDUser(int IDUser) {
        this.IDUser.setText(String.valueOf(IDUser));
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            refresh();
//            readAll();
        } catch (SQLException ex) {
            Logger.getLogger(CheckUserGroupScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public List<Groups> insertAll() throws SQLException {
        state = connexion.createStatement();
               String req = "SELECT `nameGroup` FROM `groups` WHERE `idGroup` IN (SELECT `idGroup` FROM `groupuser` WHERE `idUser`=60)"; //"+this.IDUser.getText()+"
        ResultSet rs = state.executeQuery(req);
        while (rs.next()) {
            arrayGroup.add(new Groups(rs.getString(1), rs.getInt(2) ));
        }
        
        return arrayGroup;
}
    public void refresh() throws SQLException {
               listGroups.addAll(insertAll());
        IDGroup.setCellValueFactory(new PropertyValueFactory<>("idGroup"));
        NameGroup.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
        TableGroup.setItems(listGroups);

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
        sortedData.comparatorProperty().bind(TableGroup.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        TableGroup.setItems(sortedData);
    }

}
