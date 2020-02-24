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
import pidev.Entite.Animal;
import pidev.IService.IService;

/**
 *
 * @author hp
 */
public class ServiceAnimal implements IService<Animal> {

    private Connection con;
    private Statement ste;

    public ServiceAnimal() {
        con = DataBase.getInstance().getConnection();

    }

    public void add(Animal t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit`.`animal` ( `idAnimal`, `race`, `saison`, `place`) VALUES ( ?, ?, ?, ?);");
        pre.setInt(1, t.getIdAnimal());
        pre.setString(2, t.getRace());
        pre.setString(3, t.getSaison());
        pre.setString(4, t.getPlace());
        pre.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `esprit`.`animal` WHERE `idAnimal`=?;");
        pre.setInt(1, id);
        pre.executeUpdate();
    }

    @Override
    public void update(Animal t, int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE  `esprit`.`animal` SET `idAnimal`=?, `race`=?, `saison`=?, `place`=?  WHERE `idAnimal`=?;");
        pre.setInt(1, t.getIdAnimal());
        pre.setString(2, t.getRace());
        pre.setString(3, t.getSaison());
        pre.setString(4, t.getPlace());
        pre.setInt(5, id);
        pre.executeUpdate();
    }

    @Override
    public List<Animal> readAll() throws SQLException {

        List<Animal> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from animal");
        while (rs.next()) {
            int idAnimal = rs.getInt(1);
            String race = rs.getString(2);
            String saison = rs.getString(3);
            String place = rs.getString(4);
            Animal p = new Animal(idAnimal, race, saison, place);
            arr.add(p);
        }
        return arr;

    }

    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
