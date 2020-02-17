/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UpdateUserScreenController implements Initializable {

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
    private Button UpdateUserButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setNomUL(String nomUL) {
        this.FnameUser.setText(nomUL);
    }

    public void setPnomUL(String pnomUL) {
        this.LnameUser.setText(pnomUL);
    }

    public void setPhoneUL(int phoneUL) {
        this.PhoneUser.setText(phoneUL+"");
    }

    public void setRoleUL(int roleUL) {
        this.RoleUser.setText(roleUL+"");
    }

    public void setEmailUL(String emailUL) {
        this.EmailUser.setText(emailUL);
    }

    public void setPsswdUL(String psswdUL) {
        this.PasswordUser.setText(psswdUL);
    }
    
    @FXML
    private void updateUser(ActionEvent event) {
        
        JOptionPane.showMessageDialog(null, "User Updated");
                // close window after adding a user (it works dont ask because i dont know how 
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
