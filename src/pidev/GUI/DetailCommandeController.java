/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author hp
 */
public class DetailCommandeController {

    @FXML
    private Label lbproduit;
    @FXML
    private Label lbdate;
    @FXML
    private Label lbclient;

    public void setLbproduit(String lbproduit) {
        this.lbproduit.setText(lbproduit);
    }

    public void setLbdate(String lbdate) {
        this.lbdate.setText(lbdate);
    }

    public void setLbclient(int lbclient) {
        this.lbclient.setText(String.valueOf(lbclient));
    }
    
    
    
}
