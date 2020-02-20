/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

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
public class SignUpScreenController implements Initializable {

    @FXML
    private TextField FnameTextField;
    @FXML
    private TextField LnameTextField;
    @FXML
    private TextField PhoneTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private PasswordField RePasswordTextField;
    @FXML
    private Button SignUpButton;
    @FXML
    private Hyperlink SignInHyperlink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goSignUp(ActionEvent event) {
    }

    @FXML
    private void goSignInScreen(ActionEvent event) {
    }
    
}
