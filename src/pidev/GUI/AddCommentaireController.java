/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AddCommentaireController implements Initializable {

    @FXML
    private TableColumn<Commentaire,Integer> columnIdUser;
    @FXML
    private TableColumn<Commentaire,String> columnChampCommentaire;
    @FXML
    private TextField tfUserId1;
    @FXML
    private TextField tfUserComment;
    private TextField tfIdCommentaire;
    private TextField tfIdCommentaireRS;
    @FXML
    private TextArea tfUserAnnonce;
    @FXML
    private TableView<Commentaire> tableCommentaires;
    @FXML
    private TextField tfUserId;
    @FXML
    private Button addCommentaire;
    @FXML
    private Button deleteCommentaire;
    @FXML
    private TextField tfIdAnnonce;
    @FXML
    private Label labelLastNameCurrentUser;
    @FXML
    private Label labelNameCurrentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addCommentaire(ActionEvent event) throws SQLException {
        ServiceCommentaire SA=new ServiceCommentaire();
        SA.ajouter(new Commentaire(Integer.parseInt(tfUserId1.getText()),Integer.parseInt(tfIdCommentaireRS.getText()),Integer.parseInt(tfIdCommentaire.getText()),tfUserComment.getText()));       
        JOptionPane.showMessageDialog(null, "Commentaire added");
    }

    private void updateCommentaire(ActionEvent event) throws IOException {
        ServiceCommentaire sa = new ServiceCommentaire();
        //sa.update(new Commentaire(tfUserComment.getText()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCommentaire.fxml"));
        Parent root = loader.load();
        tfIdCommentaire.getScene().setRoot(root);

        JOptionPane.showMessageDialog(null, "Comment Updated");
        // close window after adding
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
   
    
    }

    @FXML
    private void deleteCommentaire(ActionEvent event) throws SQLException {
        ServiceCommentaire SC = new ServiceCommentaire();
        SC.delete(Integer.parseInt(tfIdCommentaire.getText()));
        JOptionPane.showMessageDialog(null, "Comment Deleted");
    }
    
    
}
