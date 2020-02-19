/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import entity.productEntity;
import service.ProductService;

/**
 *
 * @author Dorsaf
 */
public class Product {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);
        
        productEntity p1 = new productEntity("gun","a hunting gun","www.google.com", (float) 32.55,4);
        productEntity p2 = new productEntity("knife","a hunting knife","www.google.com", (float) 29.50,1);
        productEntity p3 = new productEntity("silver knife","a silver knife to hunt wearwolfs","www.google.com", (float) 250.05,4);
        productEntity p4 = new productEntity("shot gun","a hunting shot gun","www.google.com", (float) 50.9,2);
        productEntity p5 = new productEntity("shot gun","a hunting shot gun","www.google.com", (float) 50.9,2);
        productEntity p6 = new productEntity("shooting gun","a hunting shot gun.....","www.google.com", (float) 60.9,3);
        
         ProductService ps=new ProductService();
       // ps.insert(p1);
       // ps.insert(p2);
       // ps.insert(p3);
       // ps.insert(p4);
       //ps.insert(p5);
        
       // ps.delete(8);
       // ps.insert(p6);
      // ps.update(p5,8);
       
       
        
        ps.readAll().forEach(System.out::println);
        
        //ps.sortByPrice().forEach(System.out::println);
        
       // ps.searchByName("gun").forEach(System.out::println);
        
        
        
        
        
    }
    
}
