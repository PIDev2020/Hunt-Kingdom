/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.Entite.Users;
import pidev.GUI.Navigation;
import pidev.Service.UserService;

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
    Navigation nav = new Navigation();
    UserService US = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void goSignUp(ActionEvent event) throws SQLException {
        int phone = Integer.parseInt(PhoneTextField.getText());
        String mailReciver = EmailTextField.getText();
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(mailReciver);
        if (PasswordTextField.getText().equals(RePasswordTextField.getText())) {
            if (PasswordTextField.getText().length() >= 8 && RePasswordTextField.getText().length() >= 8) {
                if (PhoneTextField.getText().length() >= 8) {
                    if (controler.matches()) {
                        US.add(new Users(FnameTextField.getText(), LnameTextField.getText(), phone, EmailTextField.getText(), PasswordTextField.getText()));
                        //sending mail 
                        SendMail.sendMail(mailReciver, "Welcome", "you are now a member of HUNT Kingdom Community");
                        //API SMS

                        // close window after adding a user (it works dont ask because i dont know how 
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        JOptionPane.showMessageDialog(null, "Account successfully created");
                        stage.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "E-mail is invalid");
                        EmailTextField.clear();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number is invalid");
                    PhoneTextField.clear();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password is too short");
                PasswordTextField.clear();
                RePasswordTextField.clear();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password doesn't match");
            RePasswordTextField.clear();
            PasswordTextField.clear();
        }
    }

    @FXML
    void goSignInScreen(ActionEvent event) throws IOException {
        nav.navigateLoginScreen(event);
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
