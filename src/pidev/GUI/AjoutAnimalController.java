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
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Service.ServiceAnimal;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjoutAnimalController implements Initializable {

    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfrace;
    @FXML
    private TextField tfseason;
    @FXML
    private TextField tfplace;
    @FXML
    private Button btnaa;
    @FXML
    private ImageView img;
  
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           File file = new File("images/a.jpg");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }    
    @FXML
    private void AjouterUnAnimal(ActionEvent event) throws SQLException, IOException  {
        ServiceAnimal sa=new ServiceAnimal();
        sa.ajouter(new Animal(Integer.parseInt(tfnumber.getText()),tfrace.getText(),tfseason.getText(),tfplace.getText()));
        JOptionPane.showMessageDialog(null, "Animal Added");
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("DetailAnimal.fxml"));
        Parent root=loader.load();
        tfnumber.getScene().setRoot(root);
        
        DetailAnimalController dac=loader.getController();
        dac.setLbnumber(Integer.parseInt(tfnumber.getText()));
        dac.setLbrace(tfrace.getText());
        dac.setLbseason(tfseason.getText());
        dac.setLbplace(tfplace.getText());
        
        
    }
    
}
