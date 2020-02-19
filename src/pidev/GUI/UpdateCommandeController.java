/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UpdateCommandeController implements Initializable {

    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfproduit;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfclient;
    @FXML
    private Button btnac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setTfnumber(int tfnumber) {
        this.tfnumber.setText(String.valueOf(tfnumber));
    }

    public void setTfproduit(String tfproduit) {
        this.tfproduit.setText(tfproduit);
    }

    public void setTfdate(String tfdate) {
        this.tfdate.setText(tfdate);
    }

    public void setTfclient(int tfclient) {
        this.tfclient.setText(String.valueOf(tfclient));
    }

    public void setBtnac(Button btnac) {
        this.btnac = btnac;
    }
    
    

    @FXML
    private void updateCommande(ActionEvent event) throws SQLException, IOException {
        ServiceCommande sc=new ServiceCommande();
        sc.update(new Commande(Integer.parseInt(tfnumber.getText()),tfproduit.getText(),tfdate.getText(),Integer.parseInt(tfclient.getText())),Integer.parseInt(tfnumber.getText()));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("TableCommande.fxml"));
        Parent root=loader.load();
        tfnumber.getScene().setRoot(root);

        JOptionPane.showMessageDialog(null, "Commande Updated");
                // close window after adding
                /*   final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();*/
    }
    
    }
    

