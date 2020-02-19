/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class ShowGUScreenController implements Initializable {

    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button refreshButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private TableView<?> Table;
    @FXML
    private Label IDGroup;
    @FXML
    private TableColumn<?, ?> IdGU;
    @FXML
    private TableColumn<?, ?> IdUser;
    @FXML
    private TableColumn<?, ?> IdGroup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    void refresh() {
    }

    @FXML
    void deleteGroup(ActionEvent event) {
    }

    @FXML
    void updateGroup(ActionEvent event) {
    }
    
}
