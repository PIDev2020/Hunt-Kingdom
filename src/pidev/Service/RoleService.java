/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Role;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class RoleService implements IService<Role> {

    private final Connection connexion;
    private Statement state;

    public RoleService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Role t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Role t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> readAll() throws SQLException {
        List<Role> arrayRole = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select * from Roles");
        while (rs.next()) {
            arrayRole.add(new Role(rs.getInt(1), rs.getString(2)));
            System.out.println(arrayRole);
        }
        return arrayRole;
    }

}
