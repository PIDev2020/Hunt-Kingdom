/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.IService;

/**
 *
 * @author elhak
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
    List<T> orderByName(int orderType) throws SQLException;
    List<T> readAll() throws SQLException;
}

