/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Users;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class AddUserScreenController implements Initializable {

    @FXML
    private TextField FnameUser;
    @FXML
    private TextField LnameUser;
    @FXML
    private TextField PhoneUser;
    @FXML
    private TextField EmailUser;
    @FXML
    private PasswordField PasswordUser;
    @FXML
    private TextField RoleUser;
    @FXML
    private Button AddUserButton;
    @FXML
    private AnchorPane Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addUser(ActionEvent event) throws SQLException {

        UserService US = new UserService();
        int phone = Integer.parseInt(PhoneUser.getText());
        int role = Integer.parseInt(RoleUser.getText());
        US.add(new Users(FnameUser.getText(), LnameUser.getText(), phone, role, EmailUser.getText(), PasswordUser.getText()));
        JOptionPane.showMessageDialog(null, "User added");
        // close window after adding a user (it works dont ask because i dont know how 
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
