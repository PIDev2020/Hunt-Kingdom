/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.service;

import pidev.Entite.User;
import pidev.Entite.productEntity;
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
import pidev.DataBase.DataBase;
import pidev.IService.IService;

/**
 *
 * @author Dorsaf
 */
public class ProductService implements IService<productEntity> {
    
    private Connection cnx;
    private Statement st;
    private Statement st2;
    private PreparedStatement pst;
    private ResultSet rs;
    private ResultSet rs2;
    public ProductService() {
        
       cnx= DataBase.getInstance().getConnection();
        
    }
    
    
    @Override
    public void insert(productEntity p){
        String req= " insert into product (Name,Description,Photo,Price,IdUser) values('"+p.getName()+"','"+p.getDescription()+"','"+p.getPhoto()+"','"+p.getPrice()+"','"+p.getOwner().getIdUser()+"') ";
        System.out.println(p.getOwner().getIdUser());
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
    public List<productEntity> readAll() throws SQLException  {
        List<productEntity> list= new ArrayList<>();
        String req="select * from product";
            
       
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
           
            while(rs.next()){
                
                
                int idowner= rs.getInt(6);
                
                String req2 ="select * from user where idUser='"+idowner+"'";
                
                st2=cnx.createStatement();
                rs2=st2.executeQuery(req2);
                User u = new User();
                while(rs2.next()){
                u.setIdUser(idowner);
                u.setName(rs2.getString(2));
                u.setLastname(rs2.getString(3));
                }
                
               list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , u ));
               System.out.println(u);
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
                
            }
            
            
                    
        
        return list;
    }


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


    public List<productEntity> searchByIDuser(int idu) throws SQLException {
        
          List<productEntity> list= new ArrayList<>();
        String req="select * from product where idUser='"+idu+"'";
            
       
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
           
            while(rs.next()){
                
                
                int idowner= rs.getInt(6);
                
                String req2 ="select * from user where idUser='"+idowner+"'";
                
                st2=cnx.createStatement();
                rs2=st2.executeQuery(req2);
                User u = new User();
                while(rs2.next()){
                u.setIdUser(idowner);
                u.setName(rs2.getString(2));
                u.setLastname(rs2.getString(3));
                }
                
               list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , u ));
               System.out.println(u);
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
                
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
                
                
                int idowner= rs.getInt(6);
                String req2 ="select * from user where id='"+idowner+"'";
                
                st=cnx.createStatement();
                rs2=st.executeQuery(req2);
                
                User u = new User(rs2.getString(2), rs.getString(3));
                
               list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , u ));
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
                
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<productEntity> getuserprod(int id) {
        List<productEntity> list= new ArrayList<>();
     
        String req="select * from product where IdUser="+id+"'" ;
        
         try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
             while(rs.next()){
                 
                 String req2 ="select * from user where IdUser='"+id+"'";
                
                st=cnx.createStatement();
                rs2=st.executeQuery(req2);
                User u = new User();
                while(rs2.next()){
                u.setIdUser(id);
                u.setName(rs2.getString(2));
                u.setLastname(rs2.getString(3));
             list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , u ));
             }
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list; 
        
    }

    @Override
    public List<productEntity> test(String a) {
        List<productEntity> list= new ArrayList<>();
        String req="select * from product where Name='"+a+"'";
            
       try {
            
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next()){
                
                
                int idowner= rs.getInt(6);
                String req2 ="select * from user where IdUser='"+idowner+"'";
                
                st=cnx.createStatement();
                rs2=st.executeQuery(req2);
                User u = new User();
                while(rs2.next()){
                u.setIdUser(idowner);
                u.setName(rs2.getString(2));
                u.setLastname(rs2.getString(3));
                
               list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , u ));
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getInt(6) ));
                
            }
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void ajouter(productEntity t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(productEntity t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<productEntity> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
