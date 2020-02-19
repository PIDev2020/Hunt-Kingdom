/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.productEntity;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import product.Product;
import service.ProductService;

/**
 * FXML Controller class
 *
 * @author Dorsaf
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField desc;
    @FXML
    private TextField url;
    @FXML
    private TextField price;
    @FXML
    private Button addprod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void Ajout(ActionEvent event) throws IOException {
        ProductService ps=new ProductService();
        
        ps.insert(new productEntity(name.getText(), desc.getText(),url.getText(),Float.valueOf(price.getText()),1 ));
        
        JOptionPane.showMessageDialog(null, "product added");
        
        
        
       
    }

   
    
    
    
    
}
