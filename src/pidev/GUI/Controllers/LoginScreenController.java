/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.DataBase.DataBase;
import pidev.GUI.Navigation;

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

    Navigation nav = new Navigation();
    private final Connection connexion;
    private Statement state;

    public LoginScreenController() {
        connexion = DataBase.getInstance().getConnection();
    }

    /**
     * initialises the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        int idr = 0;
        String emailUser = LoginTextField.getText();
        String passwordUser = PasswordTextField.getText();
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(emailUser);

        if (emailUser.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your email id");
            return;
        }
        if (passwordUser.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter password");
        }
        if (passwordUser.length() >= 8 && controler.matches()) {
            String sql = "SELECT * FROM Users WHERE emailUser = ? and passwordUser = ?";
            PreparedStatement PrepState = connexion.prepareStatement(sql);
            PrepState.setString(1, emailUser);
            PrepState.setString(2, passwordUser);
            ResultSet rs = PrepState.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Please enter correct Email and Password");
                LoginTextField.clear();
                PasswordTextField.clear();
            } else {
                JOptionPane.showMessageDialog(null, "Login Successfull");
                final Node node = (Node) event.getSource();
                final Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                String req = "SELECT idRole FROM Users WHERE emailUser = ?";
                PrepState = connexion.prepareStatement(req);
                PrepState.setString(1, emailUser);
                ResultSet RS = PrepState.executeQuery();
                while (RS.next()) {
                    idr = RS.getInt(1);
                }
                if (idr == 0) {
                    System.out.println("admin " + idr);
                    stage.setScene(FXMLLoader.load(getClass().getResource("FXML/HomeScreen.fxml")));
                } else {
                    System.out.println("clients " + idr);
                    stage.setScene(FXMLLoader.load(getClass().getResource("FXML/HomeScreen.fxml")));
                }

                stage.show();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login or password is invalid");
            LoginTextField.clear();
            PasswordTextField.clear();
        }

    }

    @FXML
    void goSignUpScreen(ActionEvent event) throws IOException {
        nav.navigationSignUpScreen(event);
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void sendMailForgotPassword(ActionEvent event) {
        String mailReciver = LoginTextField.getText();
        SendMail.sendMail(mailReciver, "Forgotten Password", "Contact admin!");
    }

}
