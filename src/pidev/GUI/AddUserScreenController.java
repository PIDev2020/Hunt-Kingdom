/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pidev.Entite.Role;
import pidev.Entite.Users;
import pidev.Service.RoleService;
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
    private ComboBox<Role> RolePicker;
    @FXML
    private Button AddUserButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        
        
    }    
    private void add(ActionEvent event) throws SQLException, IOException {
        UserService US = new UserService();
        int phone = Integer.parseInt(PhoneUser.getText());
        int role = Integer.parseInt(RolePicker.getId());
        US.add(new Users(FnameUser.getText(), LnameUser.getText(), phone, role, EmailUser.getText(), PasswordUser.getText()));
        JOptionPane.showMessageDialog(null, "User added");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserScreen.fxml"));
        Parent root = loader.load();
        AddUserButton.getScene().setRoot(root);
    
}

}
