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
import pidev.Entite.Users;

/**
 *
 * @author Testouri Mohamed
 */
public class UserService {

    private final Connection connexion;
    private Statement state;

    public UserService() {
        connexion = DataBase.getInstance().getConnection();
    }

    public void add(Users u) throws SQLException {
        PreparedStatement PerpState = connexion.prepareStatement("INSERT INTO Users (fnameUser,lnameUser,phoneUser,roleUser,emailUser,passwordUser) VALUES (?, ?, ?, ?, ?, ?);");
        PerpState.setString(1, u.getFnameUser());
        PerpState.setString(2, u.getLnameUser());
        PerpState.setInt(3, u.getPhoneUser());
        PerpState.setInt(4, u.getRoleUser());
        PerpState.setString(5, u.getEmailUser());
        PerpState.setString(6, u.getPasswordUser());
        PerpState.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement PerpState = connexion.prepareStatement("DELETE FROM Users WHERE idUser=?");
        PerpState.setInt(1, id);
        PerpState.executeUpdate();
    }

    public void delete(String emailUser) throws SQLException {
        PreparedStatement PerpState = connexion.prepareStatement("DELETE FROM Users WHERE emailUser=?");
        PerpState.setString(1, emailUser);
        PerpState.executeUpdate();
    }

    public void update(Users u) throws SQLException {

    }

    public List<Users> readAll() throws SQLException {
        List<Users> arrayUsers = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select * from Users");
        while (rs.next()) {

            arrayUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6) ));
        }
        return arrayUsers;
    }
}
