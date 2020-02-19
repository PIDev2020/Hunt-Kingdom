/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.productEntity;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.ProductService;

/**
 * FXML Controller class
 *
 * @author Dorsaf
 */
public class UpdateProductController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField desc;
    @FXML
    private TextField url;
    @FXML
    private TextField price;
    @FXML
    private Button updateprod;
    private int idprod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Update(ActionEvent event) {
        
        ProductService ps=new ProductService();
        
        ps.update(new productEntity(this.idprod, name.getText(), desc.getText(),url.getText(),Float.valueOf(price.getText()) ,1) );
        
        JOptionPane.showMessageDialog(null, "product updated");
        
        
    }

    
    
    public void setName(String n) {
        this.name.setText(n);   }

    public void setDesc(String d) {
        this.desc.setText(d);
    }

    public void setUrl(String u) {
        this.url.setText(u);
    }

    public void setPrice(float f) {
        this.price.setText(String .valueOf(f));
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }
    
    
    
}
