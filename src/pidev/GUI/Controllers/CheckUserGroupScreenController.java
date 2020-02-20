/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.FXML;

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
public class CheckUserGroupScreenController implements Initializable {

    @FXML
    private Label IDUser;
    @FXML
    private TableColumn<?, ?> NameGroup;
    @FXML
    private TableColumn<?, ?> IDGroup;
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
