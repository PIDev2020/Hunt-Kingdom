/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MenuController implements Initializable {

    @FXML
    private Button HomeButton;
    @FXML
    private Button UserButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button OrderButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;
    @FXML
    private AnchorPane AnchorMain;
    @FXML
    private Button AnimalButton;
    @FXML
    private Button btns;
    @FXML
    private Button btnms;

    public void setAnchorMain(AnchorPane pane) {
        this.AnchorMain.getChildren().setAll(pane);
    }
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goHomeScreen(ActionEvent event) throws IOException {
       
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UserAnimal.fxml"));
        AnchorMain.getChildren().setAll(pane);  
    }

    @FXML
    private void goUsersScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UserPanier.fxml"));
        AnchorMain.getChildren().setAll(pane);  
    }

    @FXML
    private void goGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnimalScreen(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TableAnimal.fxml"));
        AnchorMain.getChildren().setAll(pane);  
    }
    
    @FXML
    private void goProductsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("listProducts.fxml"));
        AnchorMain.getChildren().setAll(pane);  
    }

    @FXML
    private void goOrdersScreen(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TableCommande.fxml"));
        AnchorMain.getChildren().setAll(pane); 
    }

    @FXML
    private void goEventsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) {
        
    }

    @FXML
    private void signOut(ActionEvent event) {
    }

    @FXML
    private void loadall(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("userShopList.fxml"));
        AnchorMain.getChildren().setAll(pane); 
    }

    @FXML
    private void loadmyshop(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("userShop.fxml"));
        AnchorMain.getChildren().setAll(pane); 
    }
    
}
