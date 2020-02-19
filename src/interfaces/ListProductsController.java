/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.User;
import entity.productEntity;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import service.ProductService;

/**
 * FXML Controller class
 *
 * @author Dorsaf
 */
public class ListProductsController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Button SearchButton;
    @FXML
    private TableView<productEntity> Table;
    @FXML
    private TableColumn<productEntity, Integer> idproduct;
    @FXML
    private TableColumn<productEntity, String> name;
    @FXML
    private TableColumn<productEntity, String> descr;
    @FXML
    private TableColumn<productEntity, Float> price;
    @FXML
    private TableColumn<productEntity, Integer> iduser;
    @FXML
    private TableColumn<User, String> nameuser;
    @FXML
    private TableColumn<User, String> lastname;
    @FXML
    private Button RemoveButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button AddButton;
    @FXML
    private TableColumn<?, ?> owner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idproduct.setCellValueFactory(new PropertyValueFactory<productEntity, Integer>("IdProduct"));
         name.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Name"));
         descr.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Description"));
         price.setCellValueFactory(new PropertyValueFactory<productEntity, Float>("Price"));
         iduser.setCellValueFactory(new PropertyValueFactory<productEntity, Integer>("IdUser"));
        
         nameuser.setCellValueFactory(c->  new SimpleStringProperty("jon"));
         lastname.setCellValueFactory(c-> new SimpleStringProperty("doe"));
       
       
         ObservableList<productEntity> data = FXCollections.<productEntity>observableArrayList();
         ProductService ps=new ProductService();
        
         data.addAll(ps.readAll());
         Table.getItems().setAll(data);
         
         FilteredList<productEntity> filteredData = new FilteredList<>(data, b -> true);
         
         
         
         
         searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(product -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(product.getIdProduct()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (product.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (String.valueOf(product.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<productEntity> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(Table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		Table.setItems(sortedData);
               
         
        
    }  
    
    private List<productEntity> productList(){
        // parse and construct User datamodel list by looping your ResultSet rs
        // and return the list   
        ObservableList<productEntity> data = FXCollections.<productEntity>observableArrayList();
        ProductService ps=new ProductService();
        
        data.addAll(ps.readAll());
        return data;
        
    }
    
    @FXML
    private void AddProduct(ActionEvent event) throws IOException {
        
        
        
        
        //show new scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addProduct.fxml"));
        
        Parent root = loader.load();
        
        Table.getScene().setRoot(root);
        
        
    }
    @FXML
    private void Delete(ActionEvent event) throws IOException {
        
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        
        ProductService ps=new ProductService();
        
        ps.delete(prod.getIdProduct());
        
        JOptionPane.showMessageDialog(null, "product deleted");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listProducts.fxml"));
        
        Parent root = loader.load();
        
        Table.getScene().setRoot(root);
        
       
        
        
    }
    @FXML
    private void Update(ActionEvent event) throws IOException {
        
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("updateProduct.fxml"));
        
        Parent root = loader.load();
        
        Table.getScene().setRoot(root);
        
        UpdateProductController upc =loader.getController();
        
        upc.setName(prod.getName());
        upc.setDesc(prod.getDescription());
        upc.setUrl(prod.getPhoto());
        upc.setPrice(prod.getPrice());
        upc.setIdprod(prod.getIdProduct());
        
        
        
        
       
        
    }
    
}
