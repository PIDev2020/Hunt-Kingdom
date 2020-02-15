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
import pidev.Entite.Commande;
import pidev.IService.IService;

/**
 *
 * @author hp
 */
public class ServiceCommande implements IService<Commande> {

    private final Connection con;
    private Statement ste;

    public ServiceCommande() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Commande t) throws SQLException {
        PreparedStatement pre;
        pre = con.prepareStatement("INSERT INTO `esprit`.`commande` ( `idCommande`, `date`, `idUser`) VALUES ( ?, ?, ?);");
        pre.setInt(1, t.getIdCommande());
        pre.setString(2, t.getDate());
        pre.setInt(3, t.getIdUser());
        pre.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `esprit`.`commande` WHERE `idCommande`=?;");
        pre.setInt(1, id);
        pre.executeUpdate();
    }

    @Override
    public void update(Commande t, int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE  `esprit`.`commande` SET `idCommande`=?, `date`=?, `idUser`=? WHERE `idCommande`=?;");
        pre.setInt(1, t.getIdCommande());
        pre.setString(2, t.getDate());
        pre.setInt(3, t.getIdUser());
        pre.setInt(4, id);
        pre.executeUpdate();
    }

    @Override
    public List<Commande> readAll() throws SQLException {
        List<Commande> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commande");
        while (rs.next()) {
            int idCommande = rs.getInt(1);
            String date = rs.getString(2);
            int idUser = rs.getInt(3);
            Commande p = new Commande(idCommande, date, idUser);
            arr.add(p);
        }
        return arr;
    }

    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
