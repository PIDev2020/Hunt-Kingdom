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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.Entite.Users;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UserScreenController implements Initializable {

    @FXML
    private AnchorPane Pane;
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
    private Button DeleteButton;
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
    void deleteUser(ActionEvent e) throws SQLException {
        UserService US = new UserService();
        US.delete(IDUser.getCellData(Table.getSelectionModel().getSelectedIndex()));
        Table.refresh();

    }

    @FXML
    void updateUser(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateUserScreen.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Hunt Kingdom | Admin | Update User");
//        stage.setScene(new Scene(root1));
//        stage.show();
    }

    @FXML
    void addUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddUserScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Add User");
        stage.setScene(new Scene(root1));
        stage.show();
    }

}

   