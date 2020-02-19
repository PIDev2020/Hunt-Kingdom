/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class AjoutCommandeController {

    @FXML
    private TextField tfproduit;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfclient;
    @FXML
    private Button btnac;
    @FXML
    private TextField tfnumber;

    @FXML
    private void AjouterUneCommande(ActionEvent event) throws SQLException, IOException {
        ServiceCommande sa=new ServiceCommande();
        sa.ajouter(new Commande(tfproduit.getText(),tfdate.getText(),Integer.parseInt(tfclient.getText())));
        JOptionPane.showMessageDialog(null, "Commande Added");
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("DetailCommande.fxml"));
        Parent root=loader.load();
        tfproduit.getScene().setRoot(root);
        
        DetailCommandeController dac=loader.getController();
        dac.setLbproduit(tfproduit.getText());
        dac.setLbdate(tfdate.getText());
        dac.setLbclient(Integer.parseInt(tfclient.getText()));
    }
    
}
