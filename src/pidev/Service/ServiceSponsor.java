/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Sponsor;
import pidev.IService.IService;

/**
 *
 * @author USER
 */
public class ServiceSponsor implements IService<Sponsor>{
    private Connection con;
    private Statement ste ;
    
    
    public ServiceSponsor(){
        con =DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Sponsor t) throws SQLException {
      ste= con.createStatement();
      String requeteInsert="INSERT INTO `testevent`.`sponsor` (`idSponsor`,`nom`,`idEvent`,`confirmation`)VALUES ('" +t.getIdSponsor() + "' ,'" +t.getNom() + "','" +t.getIdEvent() +"' ,'" +t.getConfirmation() + "' );";   
      ste.executeUpdate(requeteInsert);
    }
     public void ajouter1(Sponsor e) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO testevent.`sponsor` (`idSponsor`,`nom`,`idEvent`,`confirmation`) VALUES ( ?, ?, ?, ?);");
        
        PS.setInt(1,e.getIdSponsor());
        PS.setString(2,e.getNom());
        PS.setInt(3,e.getIdEvent());
        PS.setInt(5, e.getConfirmation());
        
        PS.executeUpdate();
    }
     
      
    @Override
    public void delete(int id) throws SQLException {
             PreparedStatement PS = con.prepareStatement("DELETE FROM `testevent`.`sponsor` WHERE `idSponsor`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

   

    @Override
    public void update(Sponsor e, int id) throws SQLException {
      PreparedStatement PS=con.prepareStatement("UPDATE testevent.`sponsor` SET `idSponsor`=?,`nom`=?,`idSponsor`=?,`confirmation`=?");
        PS.setInt(1,e.getIdSponsor());
        PS.setString(2,e.getNom());
        PS.setInt(3,e.getIdEvent());
        PS.setInt(4,e.getConfirmation());
       
        PS.executeUpdate();
    }

    @Override
    public List<Sponsor> readAll() throws SQLException {
              List<Sponsor> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from sponsor");
        while (rs.next()) {
            int idSponsor = rs.getInt(1);
            String nom = rs.getString("Nom");
            int idEvent = rs.getInt(3);
            int confirmation = rs.getInt("Confirmation");
            
            
            
            
            Sponsor e = new Sponsor(idSponsor, nom, idEvent , confirmation );
            AL.add(e);
        }
        return AL;
    
    }

    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}



    
    
