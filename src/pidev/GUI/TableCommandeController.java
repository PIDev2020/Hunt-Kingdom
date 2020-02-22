/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class TableCommandeController implements Initializable{

    @FXML
    private TableView<Commande> tablevc;
    @FXML
    private TableColumn<Commande, Integer> colnumber;
    @FXML
    private TableColumn<Commande, String> colproduit;
    @FXML
    private TableColumn<Commande, String> coldate;
    @FXML
    private TableColumn<Commande, Integer> colclient;
    @FXML
    private Button btndc;
    @FXML
    private TextField searchc;
    ObservableList<Commande> listC = FXCollections.observableArrayList();
    private ImageView imgcommande;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//              File file = new File("images/he.jpg");
//        Image image = new Image(file.toURI().toString());
//        imgcommande.setImage(image);
        refresh();
 
    }
   
    ServiceCommande ser=new ServiceCommande();
    
    
    void refresh(){
       
        ServiceCommande sc = new ServiceCommande();
       listC.clear();
       
        try {
            listC.addAll(sc.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        colnumber.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
        colproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colclient.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        tablevc.setItems(listC);

        FilteredList<Commande> filteredData = new FilteredList<>(listC, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchc.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Commande commande) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(commande.getIdCommande()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commande.getDate().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(commande.getIdUser()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commande> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the tablevciew comparator.
        // 	  Otherwise, sorting the tablevciew would have no effect.
        sortedData.comparatorProperty().bind(tablevc.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablevc.setItems(sortedData);
    }
       
       
//    }
//    @FXML
//    private void ajoutCommande(ActionEvent event) throws IOException, SQLException {
//        ServiceCommande sc = new ServiceCommande();
//        sc.ajouter(new Commande(tfproduit.getText(), tfdate.getText(), Integer.parseInt(tfclient.getText())));
//        JOptionPane.showMessageDialog(null, "Commande Added");
//        refresh();
//        
//    }
//
//    @FXML
//     private void updateProduit(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//     @FXML
//     private void updateDate(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//     @FXML
//     private void updateClient(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//
//    @FXML
//    private void deleteCommande(ActionEvent event) throws SQLException {
//        ServiceCommande sa = new ServiceCommande();
//        sa.delete(colnumber.getCellData(tablevc.getSelectionModel().getSelectedIndex()));
//        refresh();
//             JOptionPane.showMessageDialog(null, "Commande Deleted");
//    }

    @FXML
    private void Imprimer(ActionEvent event) {
    }

    
}
