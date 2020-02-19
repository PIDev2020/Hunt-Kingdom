/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.IService;

/**
 *
 * @author Testouri Mohamed
 */

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 * @param <T>
 */
public interface IService<T> {
    void add(T t) throws SQLException;
    void delete(int id) throws SQLException;
    void delete(String email) throws SQLException;
    void update(T t, int id) throws SQLException;
    List<T> readAll() throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<T> readAll(int id) throws SQLException;
}

