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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.Entite.Users;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UsersScreenController implements Initializable {

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

    /**
     * initialises the controller class.
     */
    UserService US = new UserService();
    ObservableList<Users> listUsers = FXCollections.observableArrayList();
    @FXML
    private AnchorPane UsersAnchorPane;
//        private final Connection connexion;
//    private Statement state;
//    List<Groups> arrayGroup = new ArrayList<>();
//public UsersScreenController() {
//        connexion = DataBase.getInstance().getConnection();
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }


    void goUsersScreen(ActionEvent event) {
        refresh();
    }

    void goGroupsScreen(ActionEvent event) throws IOException {
        nav.navigateGroupScreen(event);
    }


    @FXML
    void changeStatutUser(ActionEvent event) throws SQLException {
        int a = Integer.parseInt( StatutUser.getText());
        System.out.println(a);
        Integer b = IDUser.getCellData(TableUsers.getSelectionModel().getSelectedIndex());
        System.out.println(b);
//        if (Integer.parseInt( StatutUser.getText())==0){
//            US.update(new Users(FnameUser.getText(), LnameUser.getText(), Integer.parseInt(PhoneUser.getText()), EmailUser.getText(), Integer.parseInt(StatutUser.getText())),IDUser.getCellData(TableUsers.getSelectionModel().getSelectedIndex()), 1);
//        } else {
//            US.update(new Users(FnameUser.getText(), LnameUser.getText(), Integer.parseInt(PhoneUser.getText()), EmailUser.getText(), Integer.parseInt(StatutUser.getText())),IDUser.getCellData(TableUsers.getSelectionModel().getSelectedIndex()), 0);
//                    setStatutUser(0);
//        }
//        refresh();

    }

    @FXML
    void goCheckUserGroupScreen(ActionEvent event) throws IOException {
        // navigation
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckUserGroupScreen.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Groups | Groups List");
        stage.setScene(new Scene(root2));
        stage.show();
        // passer les parametres
        pidev.GUI.CheckUserGroupScreenController CUGSC = fxmlLoader.getController();
        CUGSC.setIDUser(IDUser.getCellData(TableUsers.getSelectionModel().getSelectedIndex()));
//nav.navigationCheckUserGroupScreen(event);
    }

    public void refresh() {
        listUsers.clear();
        try {
            listUsers.addAll(US.readAll());

        } catch (SQLException ex) {
            Logger.getLogger(UsersScreenController.class.getName()).log(Level.SEVERE, null, ex);
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

//    public List<Groups> insertAll() throws SQLException {
//        state = connexion.createStatement();
//        Users tmp = TableUsers.getSelectionModel().getSelectedItem();
//               String req = "SELECT `nameGroup` FROM `groups` WHERE `idGroup` IN (SELECT `idGroup` FROM `groupuser` WHERE `idUser`="+tmp.getIdUser()/*this.IDUser.getText()*/+")";
//        ResultSet rs = state.executeQuery(req);
//        while (rs.next()) {
//            arrayGroup.add(new Groups(rs.getString(1), rs.getInt(2) ));
//        }
//        
//        return arrayGroup;
    }

    

