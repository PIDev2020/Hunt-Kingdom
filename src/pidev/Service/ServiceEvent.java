
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
import pidev.Entite.Event;
import pidev.IService.IService;

/**
 *
 * @author USER
 */
public class ServiceEvent implements IService<Event>{
    private Connection con;
    private Statement ste ;
    
    public ServiceEvent(){
        con =DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Event t) throws SQLException {
      ste= con.createStatement();
      String requeteInsert="INSERT INTO `testevent`.`event` (`idEvent`,`idUser`,`titre`,`nbrplaces`,`localisation`,`hdebut`,`hfin`,`prix`)VALUES ('" +t.getIdEvent() + "' ,'" +t.getIdUser() + "','" +t.getTitre() +"' ,'" +t.getNbrplaces() +"' ,'" +t.getLocalisation() + "' ,'" +t.getHdebut()+ "' ,'" +t.getHfin()+ "' ,'" +t.getPrix()+ "' );";   
      ste.executeUpdate(requeteInsert);
    }
     public void ajouter1(Event e) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO testevent.`event` (`idEvent`,`idUser`,`titre`,`nbrplaces`, `localisation`,`hdebut`,`hfin`,`prix`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        PS.setInt(1,e.getIdEvent());
        PS.setInt(2,e.getIdUser());
        PS.setString(3,e.getTitre());
        PS.setInt(4,e.getNbrplaces());
        PS.setString(5, e.getLocalisation());
        PS.setFloat(6,e.getHdebut());
        PS.setFloat(7,e.getHfin());
        PS.setFloat(8,e.getPrix());
        PS.executeUpdate();
    }
     
      
    @Override
    public void delete(int id) throws SQLException {
             PreparedStatement PS = con.prepareStatement("DELETE FROM `testevent`.`event` WHERE `idEvent`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

   

    @Override
    public void update(Event e, int id) throws SQLException {
      PreparedStatement PS=con.prepareStatement("UPDATE testevent.`event` SET `idUser`=?,`titre`=?,`nbrplaces`=?,`localisation`=?,`hdebut`=?,`hfin`=?,`prix`=? WHERE `idEvent`=?");
        PS.setInt(1,e.getIdEvent());
        PS.setInt(2,e.getIdUser());
        PS.setString(3,e.getTitre());
        PS.setInt(4,e.getNbrplaces());
        PS.setString(5,e.getLocalisation());
        PS.setFloat(6,e.getHdebut());
        PS.setFloat(7,e.getHfin());
        PS.setFloat(8,e.getPrix());
        PS.executeUpdate();
    }

    @Override
    public List<Event> readAll() throws SQLException {
              List<Event> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from event");
        while (rs.next()) {
            int idEvent = rs.getInt(1);
            int idUser = rs.getInt("idUser");
            String titre = rs.getString("Titre");
            int nbrplaces = rs.getInt(4);
            String localisation = rs.getString("Localisation");
            float hdebut =rs.getFloat(6);
            float hfin =rs.getFloat(7);
            float prix =rs.getFloat(8);
            
            
            
            Event e = new Event(idEvent, idUser, titre, nbrplaces , localisation, hdebut, hfin, prix );
            AL.add(e);
        }
        return AL;
    
    }

    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> orderByName(int orderType) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



    
    
