/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.DataBase.DataBase;

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
        int role = 3;
        int sts = 3;
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
                String req = "SELECT idRole, statutUser FROM Users WHERE emailUser = ?";
                PrepState = connexion.prepareStatement(req);
                PrepState.setString(1, emailUser);
                ResultSet RS = PrepState.executeQuery();
                while (RS.next()) {
                    role = RS.getInt(1);
                    sts = RS.getInt(2);
                }
                if (sts == 1) {
                    if (role == 0) {
                        System.out.println("admin " + role);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                                                stage.setTitle("Hunt Kingdom | Login");
                        stage.setScene(new Scene(root1));
                        stage.show();
                        stage.close();
                    } else {
                        System.out.println("clients " + role);
                        System.out.println("Comming Soon");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account is banned!");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Login or password is invalid");
            LoginTextField.clear();
            PasswordTextField.clear();
        }

    }

    @FXML
    void goSignUpScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        stage.show();
        final Node source = (Node) event.getSource();
        final Stage stages = (Stage) source.getScene().getWindow();
        stages.close();
    }

    @FXML
    void sendMailForgotPassword(ActionEvent event) {
        String mailReciver = LoginTextField.getText();
        SendMail.sendMail(mailReciver, "Forgotten Password", "Contact admin!");
    }

}