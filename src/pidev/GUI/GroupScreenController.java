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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import pidev.Entite.Groups;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class GroupScreenController implements Initializable {

    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> MemberGroup;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button AddButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void deleteGroup(ActionEvent event) {
    }

    @FXML
    void updateGroup(ActionEvent event) {
    }

    @FXML
    void addGroup(ActionEvent event) {
    }
    
}
