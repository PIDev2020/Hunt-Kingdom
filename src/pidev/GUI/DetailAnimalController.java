/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author hp
 */
public class DetailAnimalController implements Initializable {

    @FXML
    private Label lbnumber;
    @FXML
    private Label lbrace;
    @FXML
    private Label lbseason;
    @FXML
    private Label lbplace;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
}

    public void setLbnumber(int lbnumber) {
        this.lbnumber.setText((String.valueOf(lbnumber)));
    }

    public void setLbrace(String lbrace) {
        this.lbrace.setText(lbrace);
    }

    public void setLbseason(String lbseason) {
        this.lbseason.setText(lbseason);
    }

    public void setLbplace(String lbplace) {
        this.lbplace.setText(lbplace);
    }
    
    
    
}
