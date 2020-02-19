/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class AjoutCommandeController implements Initializable{

    @FXML
    private TextField tfproduit;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfclient;
    @FXML
    private Button btnac;
    @FXML
    private ImageView imgcommande;
 
    @FXML
    private void AjouterUneCommande(ActionEvent event) throws SQLException, IOException {
        ServiceCommande sa=new ServiceCommande();
        sa.ajouter(new Commande(tfproduit.getText(),tfdate.getText(),Integer.parseInt(tfclient.getText())));
        JOptionPane.showMessageDialog(null, "Commande Added");
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
              File file = new File("images/del.jpg");
        Image image = new Image(file.toURI().toString());
        imgcommande.setImage(image);
    }
    
}
