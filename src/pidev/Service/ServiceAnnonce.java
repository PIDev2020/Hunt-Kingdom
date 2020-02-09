/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.SQLException;
import java.util.List;
import pidev.Entite.Annonce;
import pidev.IService.IService;
import pidev.DataBase.DataBase;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author elhak
 */
public class ServiceAnnonce implements IService<Annonce> {

    private Connection con;
    private Statement ste;

    public ServiceAnnonce() {
        con = DataBase.getInstance().getConnection();
    }
    
    
    
    public void ajouter(Annonce t) throws SQLException {
        ste = con.createStatement();
        String requestInsert = "INSERT INTO `testannonces`.`annonce` (`nomAnnonce`, `descriptionAnnonce`) VALUES ('" + t.getNomAnnonce() + "', '" + t.getDescriptionAnnonce() + "');";
        ste.executeUpdate(requestInsert);
    } 
    
    @Override
    public void add(Annonce a) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `testannonces`.`annonce` (`idAnnonce`,`nomAnnonce`, `descriptionAnnonce`, `idUser`) VALUES (?, ?, ?, ?);");
        PS.setInt(1,a.getIdAnnonce());
        PS.setString(2, a.getNomAnnonce());
        PS.setString(3, a.getDescriptionAnnonce());
        PS.setInt(4, a.getIdUser());
        PS.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `testannonces`.`annonce` WHERE `idAnnonce`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

    @Override
    public void update(Annonce a,int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `testannonces`.`annonce` SET `nomAnnonce`=?,`descriptionAnnonce`=? WHERE `idAnnonce`=?");
        PS.setString(1,a.getNomAnnonce());
        PS.setString(2,a.getDescriptionAnnonce());
        PS.setInt(3,id);
        PS.executeUpdate();
    }

    @Override
    public List<Annonce> readAll() throws SQLException {
        List<Annonce> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from annonce");
        while (rs.next()) {
            int idAnnonce = rs.getInt(1);
            String nomAnnonce = rs.getString("nomAnnonce");
            String descriptionAnnonce = rs.getString(3);
            int idUser = rs.getInt("idUser");
            Annonce a = new Annonce(idAnnonce, nomAnnonce,descriptionAnnonce , idUser );
            AL.add(a);
        }
        return AL;
    }
    
}
