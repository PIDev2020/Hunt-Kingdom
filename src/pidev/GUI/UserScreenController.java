/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pidev.Entite.Users;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UserScreenController implements Initializable {

    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private TableView<Users> Table;
    @FXML
    private TableColumn<Users, Integer> IDUser;
    @FXML
    private TableColumn<Users, String> FnameUser;
    @FXML
    private TableColumn<Users, String> LnameUser;
    @FXML
    private TableColumn<Users, Integer> PhoneUser;
    @FXML
    private TableColumn<Users, String> EmailUser;
    @FXML
    private Button RemoveButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button AddButton;

    /**
     * the controller class.
     *
     * @param url
     * @param rb
     */
    ObservableList<Users> listUsers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserService US = new UserService();
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
        Table.setItems(listUsers);

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
        sortedData.comparatorProperty().bind(Table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        Table.setItems(sortedData);
    }
    @FXML
    private void handleMenuButtonAction (ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == sceneButton1){
            stage = (Stage) sceneButton1.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/mvc/view/scene1.fxml"));
        } else if (event.getSource() == sceneButton2){
            stage = (Stage) flightBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/mvc/view/scene2.fxml"));
        } else if (event.getSource() == sceneButton3) {
            stage=(Stage) staffBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/mvc/view/scene3.fxml"));
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();
//FXMLLoader loader = new FXMLLoader(getClass().getResource("AddUserScreen.fxml"));
//        Parent root = loader.load();
//        AddButton.getScene().setRoot(root);
}
