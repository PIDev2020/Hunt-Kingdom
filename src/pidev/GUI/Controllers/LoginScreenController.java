/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button SignUpButton;
    @FXML
    private Hyperlink ForgotPasswordHyperling;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void goSignUpScreen(ActionEvent event) {
    }

    @FXML
    private void sendMailForgotPassword(ActionEvent event) {
    }
    
}
