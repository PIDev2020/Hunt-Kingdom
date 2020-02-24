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
import javafx.collections.ObservableList;
import pidev.DataBase.DataBase;
import pidev.Entite.Users;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class UserService implements IService<Users> {

    private final Connection connexion;
    private Statement state;

    public UserService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Users u) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO Users (fnameUser,lnameUser,phoneUser,idRole,emailUser,passwordUser) VALUES (?, ?, ?, ?, ?, ?);");
        PrepState.setString(1, u.getFnameUser());
        PrepState.setString(2, u.getLnameUser());
        PrepState.setInt(3, u.getPhoneUser());
        PrepState.setInt(4, u.getidRole());
        PrepState.setString(5, u.getEmailUser());
        PrepState.setString(6, u.getPasswordUser());
        PrepState.executeUpdate();
    }

    @Override
    public void delete(int idUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Users WHERE idUser=?");
        PrepState.setInt(1, idUser);
        PrepState.executeUpdate();
    }

    /**
     *
     * @param emailUser
     * @throws SQLException
     */
    @Override
    public void delete(String emailUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM Users WHERE emailUser=?");
        PrepState.setString(1, emailUser);
        PrepState.executeUpdate();
    }

    @Override
    public List<Users> readAll() throws SQLException {
        List<Users> arrayUsers = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select idUser, fnameUser, lnameUser, phoneUser, statutUser, emailUser from Users WHERE idRole=0");
        while (rs.next()) {
            arrayUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
        }
        return arrayUsers;
    }
//    @Override
//    public List<Users> orderFname( int typeOrder) throws SQLException {
//        List<Users> arrayUsers = new ArrayList<>();
//        state = connexion.createStatement();
//        ResultSet rs = null;
//        
//        if (typeOrder == 0 ){
//       rs = state.executeQuery("select * from Users");
//        } else if (typeOrder == 1){
//            rs = state.executeQuery("select * from Users");
//        } else {
//            System.out.println("Choose Sorting Type");
//        }
//        while (rs.next()) {
//
//            arrayUsers.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
//        }
//        return arrayUsers;
//    }

    @Override
    public void update(Users u, int idUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE Users SET fnameUser=? , lnameUser=? , phoneUser=? , emailUser=? WHERE idUser= ?");

        PrepState.setString(1, u.getFnameUser());
        PrepState.setString(2, u.getLnameUser());
        PrepState.setInt(3, u.getPhoneUser());
        PrepState.setString(4, u.getEmailUser());
        PrepState.setInt(5, idUser);
        PrepState.executeUpdate();
    }

    /**
     *
     * @param u
     * @param idUser
     * @param statutUser
     * @throws SQLException
     */
    public void update(Users u, int idUser, int statutUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE Users SET statutUser=? WHERE idUser=?");
        PrepState.setInt(1, u.getStatutUser());
        PrepState.setInt(2, idUser);
        PrepState.executeUpdate();
    }

    public void delete(ObservableList<Users> User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
