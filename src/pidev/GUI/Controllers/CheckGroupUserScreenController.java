/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class CheckGroupUserScreenController implements Initializable {

    @FXML
    private Label IDGroup;
    @FXML
    private TableColumn<?, ?> FnameUser;
    @FXML
    private TableColumn<?, ?> LnameUser;
    @FXML
    private TableColumn<?, ?> PhoneUser;
    @FXML
    private TableColumn<?, ?> IDUser;
    @FXML
    private TextField SearchTermTextFiled;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
