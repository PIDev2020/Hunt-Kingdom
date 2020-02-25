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
import pidev.Entite.Commentaire;
import pidev.GUI.Annonceid;
import pidev.IService.IService;

/**
 *
 * @author elhak
 */
public class ServiceCommentaire implements IService<Commentaire> {
    
    
    private Connection con;
    private Statement ste;

    public ServiceCommentaire() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Commentaire c) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `testannonce`.`commentaire` (`idUser`,`idAnnonceRS`,`idCommentaireRS`,`champCommentaire`) VALUES (?, ?, ?, ?);");
        PS.setInt(1,c.getIdUser());
        PS.setInt(2,c.getIdAnnonceRS());
        PS.setInt(3,c.getIdCommentaireRS());
        PS.setString(4,c.getChampCommentaire());
        PS.executeUpdate();
    }
    
    public void ajouterCom(Commentaire c) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `testannonce`.`commentaire` (`idUser`,`idAnnonceRS`,`champCommentaire`) VALUES (?, ?, ?);");
        PS.setInt(1,c.getIdUser());
        PS.setInt(2,c.getIdAnnonceRS());
        PS.setString(3,c.getChampCommentaire());
        PS.executeUpdate();
    }
    

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `testannonce`.`commentaire` WHERE `idCommentaire`=?");
        PS.setInt(1,id);       
        PS.executeUpdate();
    }

    @Override
    public void update(Commentaire c, int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `testannonce`.`commentaire` SET `champCommentaire`=? WHERE `idUser`=?");
        PS.setString(1,c.getChampCommentaire());
        PS.setInt(2,id);
        PS.executeUpdate();
    }

    @Override
    public List<Commentaire> readAll() throws SQLException {
        List<Commentaire> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commentaire");
        while (rs.next()) {
            int idCommentaire = rs.getInt(1);
            int idCommentaireRS = rs.getInt(2);
            int idUser = rs.getInt(3);
            int idAnnonceRS = rs.getInt(4);
            String champCommentaire = rs.getString(5);
            String dateCommentaire = rs.getString(6);
            Commentaire c = new Commentaire(idCommentaire,idCommentaireRS,idUser,idAnnonceRS,champCommentaire,dateCommentaire);
            AL.add(c);
        }
        return AL;
    }
    
    
    public List<Commentaire> readCom( int idAnnonce) throws SQLException {
        List<Commentaire> AL = new ArrayList<>();
        PreparedStatement pste = con.prepareStatement("select idUser,champCommentaire,dateCommentaire from commentaire where idAnnonceRS=?;");
        pste.setInt(1, idAnnonce);
        ResultSet rs = pste.executeQuery();
        
        while (rs.next()) {
//            int idCommentaire = rs.getInt(1);
//            int idCommentaireRS = rs.getInt(2);
            int idUser = rs.getInt(1);
//            int idAnnonceRS = rs.getInt(4);
            String champCommentaire = rs.getString(2);
            String dateCommentaire = rs.getString(3);
            Commentaire c = new Commentaire(idUser,champCommentaire,dateCommentaire);
            AL.add(c);
        }
        return AL;
    }
    
}
