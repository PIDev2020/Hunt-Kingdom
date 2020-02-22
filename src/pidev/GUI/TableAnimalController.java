/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.DataBase.DataBase;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;

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
    private Button btnadd;
    @FXML
    private Button btndel;
    @FXML
    private TextField tfsearch;
    private final ObservableList<Animal> listA = FXCollections.observableArrayList();
    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfrace;
    @FXML
    private TextField tfplace;
    @FXML
    private TextField tfseason;

    ServiceAnimal ser = new ServiceAnimal();
    @FXML
    private Button HomeButton;
    @FXML
    private Button UserButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button OrderButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        File file = new File("images/bow.jpg");
        Image image = new Image(file.toURI().toString());
        imga.setImage(image);
        */
        refresh();
        tablev.setEditable(true);
        colr.setCellFactory(TextFieldTableCell.forTableColumn());
        cols.setCellFactory(TextFieldTableCell.forTableColumn());
        colp.setCellFactory(TextFieldTableCell.forTableColumn());  
    }
    
    void refresh(){
       
        tfnumber.setText("");
        tfrace.setText("");
        tfseason.setText("");
        tfplace.setText("");
        try {
           ServiceAnimal sa = new ServiceAnimal();
       listA.clear();
                           
       listA.addAll(sa.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableAnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        coln.setCellValueFactory(new PropertyValueFactory<>("idA"));
        colr.setCellValueFactory(new PropertyValueFactory<>("race"));
        cols.setCellValueFactory(new PropertyValueFactory<>("saison"));
        colp.setCellValueFactory(new PropertyValueFactory<>("place"));
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
    
    @FXML
    void addanimal(ActionEvent event) throws IOException, SQLException {
        if(controle_number()==true){
        ServiceAnimal sa = new ServiceAnimal();
        sa.ajouter(new Animal(Integer.parseInt(tfnumber.getText()), tfrace.getText(), tfseason.getText(), tfplace.getText()));
        JOptionPane.showMessageDialog(null, "Animal Added");
        refresh();
        
         }
         else{
     
        refresh();
        
        }
    }
    @FXML
    private void updateRace(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setRace(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
    }
    @FXML
    private void updateSeason(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setSaison(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
    }
    @FXML
    private void updatePlace(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setPlace(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
    }

    

     

@FXML
    void deleteAnimal(ActionEvent e) throws SQLException {
        ServiceAnimal sa = new ServiceAnimal();
        sa.delete(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        refresh();
        JOptionPane.showMessageDialog(null, "Animal Deleted");
    }
    
    //LES controles
    private boolean controle_number() throws SQLException
    {
                
        for(int i=0;i<tfnumber.getText().length();i++){
        
            if(!Character.isDigit(tfnumber.getText().charAt(i))){
               
            JOptionPane.showMessageDialog(null, "Reference must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }
             ServiceAnimal sa = new ServiceAnimal();
      List<Animal> listA = sa.readAll();
            for (Animal listA1 : listA) {
                if(listA1.getIdA()==Integer.parseInt(tfnumber.getText())){
                    JOptionPane.showMessageDialog(null, "Reference already used", "Attention", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
              
    }
        return true;
    }

    @FXML
    private void goHomeScreen(ActionEvent event) {
    }

    @FXML
    private void goUsersScreen(ActionEvent event) {
    }

    @FXML
    private void goGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void goProductsScreen(ActionEvent event) {
    }

    @FXML
    private void goOrdersScreen(ActionEvent event) {
    }

    @FXML
    private void goEventsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) {
    }

    @FXML
    private void signOut(ActionEvent event) {
    }

    


}
