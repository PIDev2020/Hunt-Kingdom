/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Service.ServiceAnimal;
import pidev.GUI.UpdateAnimalController;

/**
 *
 * @author hp
 */
public class TableAnimalController implements Initializable{

    @FXML
    private TableView<Animal> tablev;
    @FXML
    private TableColumn<Animal, Integer> coln;
    @FXML
    private TableColumn<Animal, String> colr;
    @FXML
    private TableColumn<Animal, String> cols;
    @FXML
    private TableColumn<Animal, String> colp;
    @FXML
    private TableColumn<Animal, Integer> colref;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnmod;
    @FXML
    private Button btndel;
    
     ObservableList<Animal> listA = FXCollections.observableArrayList();
    @FXML
    private TextField tfsearch;
    @FXML
    private Button btnref;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh();
    }
    
    @FXML
    void addanimal(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutAnimal.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Animal");
        stage.setScene(new Scene(root1));
        stage.show();
        refresh();
    }
    @FXML
    void updateAnimal(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateAnimal.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Animal");
        stage.setScene(new Scene(root1));
        stage.show();
        
        UpdateAnimalController uac=fxmlLoader.getController();
        uac.setTfnumber(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        uac.setTfrace(colr.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        uac.setTfseason(cols.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        uac.setTfplace(colp.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        
    }

@FXML
    void deleteAnimal(ActionEvent e) throws SQLException {
        ServiceAnimal sa = new ServiceAnimal();
        sa.delete(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        refresh();
JOptionPane.showMessageDialog(null, "Animal Deleted");
    }
    
@FXML
    void refresh(){
       
        ServiceAnimal sa = new ServiceAnimal();
       listA.clear();
        try {
            listA.addAll(sa.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableAnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        coln.setCellValueFactory(new PropertyValueFactory<>("idA"));
        colr.setCellValueFactory(new PropertyValueFactory<>("race"));
        cols.setCellValueFactory(new PropertyValueFactory<>("saison"));
        colp.setCellValueFactory(new PropertyValueFactory<>("place"));
        colref.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        tablev.setItems(listA);

        FilteredList<Animal> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Animal animal) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(animal.getIdA()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (animal.getRace().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (animal.getSaison().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (animal.getPlace().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(animal.getIdAnimal()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Animal> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tablev.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablev.setItems(sortedData);

       
       
    }
}
