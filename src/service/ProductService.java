/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import entity.productEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import product.DataSource;
import product.Product;

/**
 *
 * @author Dorsaf
 */
public class ProductService implements IService<productEntity> {
    
    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    public ProductService() {
        
       cnx= DataSource.getInstance().getCnx();
        
    }
    
    
    @Override
    public void insert(productEntity p){
        String req= " insert into product (Name,Description,Photo,Price,IdUser) values('"+p.getName()+"','"+p.getDescription()+"','"+p.getPhoto()+"','"+p.getPrice()+"','"+p.getIdUser()+"') ";
        
        try {
            st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    

    
    @Override
    public void delete(int id) {
        
        String req=" DELETE from product where IdProduct="+id ;
        
         try {
            st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }

    

    @Override
    public List<productEntity> readAll() {
        List<productEntity> list= new ArrayList<>();
        String req="select * from product";
            
        try {
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next()){
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) , rs.getObject(6) ));
                list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
                
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void update(productEntity p) {
        String req=("UPDATE product SET `Name`=?,`Description`=?, `Price`=?, `Photo`=? WHERE `IdProduct`=?");
         try {
            pst=cnx.prepareStatement(req);
            pst.setString(1, p.getName());
            pst.setString(2, p.getDescription());
            pst.setFloat(3, p.getPrice());
            pst.setString(4, p.getPhoto());
            pst.setInt(5,p.getIdProduct());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<productEntity> searchByName(String name) {
        
         List<productEntity> list= new ArrayList<>();
        String req="SELECT * FROM product WHERE Name='"+name+"'";
         try {
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next()){
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getObject(6) ));
                list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<productEntity> sortByPrice() {
       List<productEntity> list= new ArrayList<>();
        String req="select * from product";
            
        try {
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next()){
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFoat(5) , rs.getObject(6) ));
                list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(list, new Comparator<productEntity>() {
			
			public int compare(productEntity o1, productEntity o2) {
				return (Float.compare(o1.getPrice(), o2.getPrice()));
			}
		});
        return list;
    }

    @Override
    public User getuser(int id) {
        User user= new User();
        String req="select * from user where IdUser="+id+"'" ;
        
         try {
            st=cnx.createStatement();
            //rs=st.executeUpdate(req);
            user.setName(rs.getString(2));
            user.setLastname(rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return user; 
        
    }
    
    
    
}
