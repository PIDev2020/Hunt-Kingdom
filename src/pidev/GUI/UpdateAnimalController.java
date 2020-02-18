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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Service.ServiceAnimal;

/**
 *
 * @author hp
 */
public class UpdateAnimalController implements Initializable{

    @FXML
    private ImageView img;
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

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/a.jpg");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    
    public void setTfnumber(int tfnumber) {
        this.tfnumber.setText(String.valueOf(tfnumber));
    }

    public void setTfrace(String tfrace) {
        this.tfrace.setText(tfrace);
    }

    public void setTfseason(String tfseason) {
        this.tfseason.setText(tfseason);
    }

    public void setTfplace(String tfplace) {
        this.tfplace.setText(tfplace);
    }
    
    @FXML
    private void updateAnimal(ActionEvent event) throws SQLException, IOException {
        
        ServiceAnimal sa=new ServiceAnimal();
        sa.update(new Animal(Integer.parseInt(tfnumber.getText()),tfrace.getText(),tfseason.getText(),tfplace.getText()),Integer.parseInt(tfnumber.getText()));
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("TableAnimal.fxml"));
        Parent root=loader.load();
        tfnumber.getScene().setRoot(root);

        JOptionPane.showMessageDialog(null, "Animal Updated");
                // close window after adding
                /*   final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();*/
    }
    
}
