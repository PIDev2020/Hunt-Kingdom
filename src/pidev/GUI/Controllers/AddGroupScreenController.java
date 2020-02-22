/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.Entite.Groups;
import pidev.Service.GroupService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class AddGroupScreenController implements Initializable {

    @FXML
    private TextField NameGroupTextField;
    @FXML
    private Button AddGroupButton;
    @FXML
    private TextField TypeGroupTextField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void addGroup(ActionEvent event) throws SQLException {
        GroupService GS = new GroupService();
        GS.add(new Groups(NameGroupTextField.getText(), TypeGroupTextField.getText()));
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
