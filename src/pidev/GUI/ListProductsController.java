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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.User;
import pidev.Entite.productEntity;
import pidev.service.ProductService;

/**
 * FXML Controller class
 *
 * @author Dorsaf
 */
public class ListProductsController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TableView<productEntity> Table;
    @FXML
    private TableColumn<productEntity, String> photo;
    @FXML
    private TableColumn<productEntity, String> name;
    @FXML
    private TableColumn<productEntity, String> descr;
    @FXML
    private TableColumn<productEntity, Float> price;
   
    @FXML
    private TableColumn<productEntity,String> nameuser;
    @FXML
    private TableColumn<productEntity, String> lastname;
    @FXML
    private Button RemoveButton;
    @FXML
    private Button AddButton;
    @FXML
    private TextField addname;
    @FXML
    private TextArea adddesc;
    @FXML
    private TextField addprice;
    @FXML
    private TextField addphoto;
    @FXML
    private TableColumn<?, ?> owner;
    @FXML
    private Button gotochart;
 ObservableList<productEntity> data = FXCollections.<productEntity>observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         refresh();
        Table.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        descr.setCellFactory(TextFieldTableCell.forTableColumn());
        photo.setCellFactory(TextFieldTableCell.forTableColumn());
       
    }  
    
    void refresh(){
        
         
         addname.setText("");
         adddesc.setText("");
         addprice.setText("");
         addphoto.setText("");
       
       
        
         ProductService ps=new ProductService();
        data.clear();
        try {
            data.addAll(ps.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ListProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         photo.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Photo"));
         name.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Name"));
         descr.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Description"));
         price.setCellValueFactory(new PropertyValueFactory<productEntity, Float>("Price"));
         nameuser.setCellValueFactory(new PropertyValueFactory<productEntity, String>("username"));
         lastname.setCellValueFactory(new PropertyValueFactory<productEntity, String>("lastname"));
        
         Table.getItems().setAll(data);
       
        
         
         
         
         
         
         
         FilteredList<productEntity> filteredData = new FilteredList<>(data, b -> true);
         
         
         
         
         searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(product -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				//or else
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(product.getIdProduct()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (product.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (String.valueOf(product.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getPhoto().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
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
    private List<productEntity> productList() throws SQLException{
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
      /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("addProduct.fxml"));
        
        Parent root = loader.load();
        
        Table.getScene().setRoot(root);
        @FXML
    private TextField addname;
    @FXML
    private TextArea adddesc;
    @FXML
    private TextField addprice;
    @FXML
    private TextField addphoto;
        */
      
       ProductService ps=new ProductService();
       
       User u = new User(2,"jon","doe"); 
        
        if(addname.getText().isEmpty() || adddesc.getText().isEmpty()|| addphoto.getText().isEmpty() || addprice.getText().isEmpty())
            
       {
          
           System.out.println("test1");
           
        JOptionPane.showMessageDialog(null, "Field cannot be empty ", "Attention", JOptionPane.ERROR_MESSAGE);
refresh();
       
           
       
       
       } else { 
       if(ps.test(addname.getText()).size() !=0){
           JOptionPane.showMessageDialog(null, "product already exist ", "Attention", JOptionPane.ERROR_MESSAGE);
        refresh();
        
        
       }         else {
                       try{
        Float.parseFloat(addprice.getText());
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "price must be a float", "Attention", JOptionPane.ERROR_MESSAGE);
        refresh();
       }
       
        ps.insert(new productEntity(addname.getText(), adddesc.getText(),addphoto.getText(),Float.valueOf(addprice.getText()), u));
        
        JOptionPane.showMessageDialog(null, "product added");
        
        
         refresh();
       }}
    }
    @FXML
    private void Delete(ActionEvent event) throws IOException {
        
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        
        ProductService ps=new ProductService();
        
        ps.delete(prod.getIdProduct());
        
        JOptionPane.showMessageDialog(null, "product deleted");
        
        refresh();
        
       
        
        
    }
    

    @FXML
    private void updatename(TableColumn.CellEditEvent e) {
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        prod.setName(e.getNewValue().toString());
        ProductService ps=new ProductService();
        ps.update(prod);
        
    }

    @FXML
    private void updatedesc(TableColumn.CellEditEvent e) {
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        prod.setDescription(e.getNewValue().toString());
        ProductService ps=new ProductService();
        ps.update(prod);
    }

    @FXML
    private void updateprice(TableColumn.CellEditEvent e) {
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        prod.setPrice(Float.valueOf(e.getNewValue().toString()));
        ProductService ps=new ProductService();
        ps.update(prod);
    }

    @FXML
    private void updatephoto(TableColumn.CellEditEvent e) {
        productEntity prod= new productEntity();
        prod = Table.getSelectionModel().getSelectedItem();
        prod.setPhoto(e.getNewValue().toString());
        ProductService ps=new ProductService();
        ps.update(prod);
    }

    @FXML
    private void goToChart(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chartPage.fxml"));
        
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        
//        Table.getScene().setRoot(root);
    }

   
    
}
