/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Annonce;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceAnnonce;
import pidev.Service.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AddCommentUserController implements Initializable {

    @FXML
    private TextField tfNomAnnonce;
    @FXML
    private TextArea tfDescriptionAnnonce;
    private TextField tfIdAnnonce;
    private TextField tfUserId;
    private int lbidAnnonce;
    @FXML
    private TableView<Commentaire> tableCommentaires;
    @FXML
    private TableColumn<Commentaire,Integer> columnIdUser;
    @FXML
    private TableColumn<Commentaire,String> columnChampCommentaire;
    @FXML
    private TableColumn<Commentaire,String> columnDate;
    @FXML
    private TextField tfUserComment;
    @FXML
    private Button btnAjouterCommentaire;
    ObservableList<Commentaire> listA = FXCollections.observableArrayList();

    public void setLbidAnnonce(int lbidAnnonce) {
        this.lbidAnnonce = lbidAnnonce;
    }

    public void setTfNomAnnonce(String tfNomAnnonce) {
        this.tfNomAnnonce.setText(tfNomAnnonce);
    }

    public void setTfDescriptionAnnonce(String tfDescriptionAnnonce) {
        this.tfDescriptionAnnonce.setText(tfDescriptionAnnonce);
    }

    public void setTfIdAnnonce(int tfIdAnnonce) {
        this.tfIdAnnonce.setText(String.valueOf(tfIdAnnonce));
    }

    public void setTfUserId(int tfUserId) {
        this.tfUserId.setText(String.valueOf(tfUserId));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        ServiceCommentaire SA = new ServiceCommentaire();
         listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        columnChampCommentaire.setCellValueFactory(new PropertyValueFactory<>("champCommentaire"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("dateCommentaire"));
        
        FilteredList<Commentaire> filteredData = new FilteredList<>(listA, lu -> true);

//        
//        // 2. Set the filter Predicate whenever the filter changes.
//        searchCommentaire.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Commentaire commentaire) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(commentaire.getIdAnnonceRS()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if ((String.valueOf(commentaire.getIdUser()).contains(lowerCaseFilter))) {
//                    return true; // Filter matches last name.
//                } else if (commentaire.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (commentaire.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commentaire> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableCommentaires.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableCommentaires.setItems(sortedData);
        
        
        
        
        
        
        
        
    }

    private void UpdateAnnonce(ActionEvent event) throws IOException, SQLException {
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.update(new Annonce(tfNomAnnonce.getText(), tfDescriptionAnnonce.getText()), lbidAnnonce);



        JOptionPane.showMessageDialog(null, "Announce Updated");
        // close window after adding
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AjouterCommentaire(ActionEvent event) {
    }

}
