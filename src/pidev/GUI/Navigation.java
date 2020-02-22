/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Testouri Mohamed
 */
public class Navigation {

    public void navigateUserScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/UsersScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Users");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateGroupScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/GroupScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Groups");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateCheckGroupUserScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CheckGroupUserScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Groups | Members List");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateCheckUserGroupScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CheckUserGroupScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Groups | Groups List");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateSignUpScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/SignUpScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Signup");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateLoginScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Login");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void navigateHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/HomeScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Home");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
