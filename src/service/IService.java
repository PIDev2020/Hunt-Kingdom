/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.List;

/**
 *
 * @author Dorsaf
 */
public interface IService<T> {
    
     void insert(T t);
      List<T> readAll();
      void delete(int id);
      void update(T t);
      List<T> searchByName(String name);
      List<T> sortByPrice();
      User getuser(int id);
      
    
}
