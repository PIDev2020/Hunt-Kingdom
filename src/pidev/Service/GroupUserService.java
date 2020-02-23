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
import pidev.Entite.GroupUser;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class GroupUserService implements IService<GroupUser>{
    private final Connection connexion;
    private Statement state;

    public GroupUserService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(GroupUser gu) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO Groupuser (idUser,idGroup) VALUES (?, ?);");
        PrepState.setInt(1, gu.getIdUser());
        PrepState.setInt(2, gu.getIdGroup());
        PrepState.executeUpdate();
    }

    @Override
    public void delete(int idGroupUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Groupuser WHERE idGroupUser=?");
        PrepState.setInt(1, idGroupUser);
        PrepState.executeUpdate();
    }

    @Override
    public void update(GroupUser gu, int idGroupUser) throws SQLException {
    PreparedStatement PrepState = connexion.prepareStatement("UPDATE Groupuser SET idUser=? , idGroup=? WHERE idGroupUser=? ");
        PrepState.setInt(1, gu.getIdUser());
        PrepState.setInt(2, gu.getIdGroup());
        PrepState.setInt(3, idGroupUser);
        PrepState.executeUpdate();    
    }

    @Override
    public List<GroupUser> readAll(int id) throws SQLException {
     List<GroupUser> arrayGroupUser = new ArrayList<>();
            state = connexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM Groupuser WHERE idGroup="+String.valueOf(id));
        while (rs.next()) {
            arrayGroupUser.add(new GroupUser(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            System.out.println(arrayGroupUser);
        }
        return arrayGroupUser;    
    }
    
    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> readAll() throws SQLException {
    List<GroupUser> arrayGroupUser = new ArrayList<>();
            state = connexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM Groupuser");
        while (rs.next()) {
            arrayGroupUser.add(new GroupUser(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            System.out.println(arrayGroupUser);
        }
        return arrayGroupUser;        
    }

    @Override
    public List<GroupUser> readALL() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
