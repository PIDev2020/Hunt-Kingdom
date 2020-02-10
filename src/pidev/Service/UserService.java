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
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO Users (fnameUser,lnameUser,phoneUser,roleUser,emailUser,passwordUser) VALUES (?, ?, ?, ?, ?, ?);");
        PrepState.setString(1, u.getFnameUser());
        PrepState.setString(2, u.getLnameUser());
        PrepState.setInt(3, u.getPhoneUser());
        PrepState.setInt(4, u.getRoleUser());
        PrepState.setString(5, u.getEmailUser());
        PrepState.setString(6, u.getPasswordUser());
        PrepState.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Users WHERE idUser=?");
        PrepState.setInt(1, id);
        PrepState.executeUpdate();
    }

    public void delete(String emailUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Users WHERE emailUser=?");
        PrepState.setString(1, emailUser);
        PrepState.executeUpdate();
    }

    public void update(Users u) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE Users SET idUser=? , fnameUser=? , lnameUser=? , phoneUser=? , emailUser=? , passwordUser=?");
        PrepState.setInt(1, u.getIdUser());
        PrepState.setString(2, u.getFnameUser());
        PrepState.setString(3, u.getLnameUser());
        PrepState.setInt(4, u.getPhoneUser());
        PrepState.setString(2, u.getFnameUser());
        PrepState.setString(2, u.getFnameUser());

    }

    public List<Users> readAll() throws SQLException {
        List<Users> arrayUsers = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select * from Users");
        while (rs.next()) {

            arrayUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
        }
        return arrayUsers;
    }
}
