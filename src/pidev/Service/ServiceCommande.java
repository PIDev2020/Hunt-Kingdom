/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Commande;
import pidev.IService.IService;

/**
 *
 * @author hp
 */
public class ServiceCommande implements IService<Commande> {
    
    private Connection con; 
    private Statement ste;
    
    public ServiceCommande(){
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Commande t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`commande` (`produit`,  `date`, `idUser`, `price`, `State`) VALUES ( ?, ?, ?, ?, ?);");
    pre.setString(1, t.getProduit());
    pre.setDate(2, t.getDate());
    pre.setInt(3, t.getIdUser());
    pre.setDouble(4, t.getPrice());
    pre.setInt(5, t.getState());
    pre.executeUpdate();
    }
    public void ajouterpanier(Commande t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`commande` (`produit`, `price`, `idUser`, `State`) VALUES ( ?, ?, ?, ?);");
    pre.setString(1, t.getProduit());
    pre.setDouble(2, t.getPrice());
    pre.setInt(3, t.getIdUser());
    pre.setInt(4, t.getState());
    pre.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `esprit`.`commande` WHERE `idCommande`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

    @Override
    public void update(Commande t, int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("UPDATE  `esprit`.`commande` SET `produit`=?, `date`=?, `idUser`=? WHERE `idCommande`=?;");
    pre.setString(1, t.getProduit());
    pre.setDate(2, t.getDate());
    pre.setInt(3, t.getIdUser());
    pre.setInt(4, id);
    pre.executeUpdate();
    }
   
    public void updatepanier(int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("UPDATE  `esprit`.`commande` SET `State`=1 WHERE `idCommande`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

    @Override
    public List<Commande> readAll() throws SQLException {
        List<Commande> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commande WHERE `State`=1");
     while (rs.next()) {                
               int idCommande=rs.getInt(1);
               String produit = rs.getString(2);
               Date date=rs.getDate(3);
               int idUser=rs.getInt(4);
               float price = rs.getFloat(5);
               int state=rs.getInt(6);
               Commande p=new Commande(idCommande, produit, date, idUser, price, state);

     arr.add(p);
     }
    return arr;
    

    }

    @Override
    public List<Commande> readPanier(int id) throws SQLException {
         List<Commande> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commande WHERE (`State`=0 And `idUser`=1) ");
     while (rs.next()) {                
               int idCommande=rs.getInt(1);
               String produit = rs.getString(2);
               Date date=rs.getDate(3);
               int idUser=rs.getInt(4);  
               float price=rs.getFloat(5);
               Commande p=new Commande(idCommande, produit, date, idUser, price);
     arr.add(p);
     }
    return arr;
    }
    

    @Override
    public void insert(Commande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
   
    }
    

