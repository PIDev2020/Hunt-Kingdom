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
import pidev.Entite.CurrentUser;
import pidev.Entite.Groups;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class GroupService implements IService<Groups> {

    private final Connection connexion;
    private Statement state;

    public GroupService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Groups g) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO Groups (nameGroup,typeGroup) VALUES (?, ?);");
        PrepState.setString(1, g.getNameGroup());
        PrepState.setString(2, g.getTypeGroup());
        PrepState.executeUpdate();
    }

    @Override
    public void delete(int idGroup) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Groups WHERE idGroup=?");
        PrepState.setInt(1, idGroup);
        PrepState.executeUpdate();
    }

    @Override
    public void delete(String nameGroup) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Groups WHERE nameGroup=?");
        PrepState.setString(1, nameGroup);
        PrepState.executeUpdate();  //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public List<Groups> readAll() throws SQLException {
        List<Groups> arrayGroup = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select * from Groups");
        while (rs.next()) {
            arrayGroup.add(new Groups(rs.getInt(1), rs.getString(2), rs.getString(3)));
            System.out.println(arrayGroup);
        }
        return arrayGroup;
    }

    @Override
    public void update(Groups g, int idGroup) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE Groups SET nameGroup=? , typeGroup=? WHERE idGroup=? ");
        PrepState.setString(1, g.getNameGroup());
        PrepState.setString(2, g.getTypeGroup());
        PrepState.setInt(3, idGroup);
        PrepState.executeUpdate();
    }

    @Override
    public List<Groups> readALL() throws SQLException {
        String sql = "SELECT `idGroup`,`nameGroup`,`typeGroup` FROM `groups` WHERE `idGroup` NOT IN (SELECT `idGroup` FROM `groupuser` WHERE `idUser`="+CurrentUser.getInstance().getUser_id()+")";
        List<Groups> arrayGroup = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()) {
            arrayGroup.add(new Groups(rs.getInt(1), rs.getString(2), rs.getString(3)));
            System.out.println(arrayGroup);
        }
        return arrayGroup;
    }

    @Override
    public List<Groups> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
