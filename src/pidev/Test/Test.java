/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.scene.control.DatePicker;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class Test {
     public static void main(String[] args) throws ParseException, SQLException {
        
//         DatePicker tmpdate=(DatePicker) date_naiss;
//                String date= (String) tmpdate.getValue().toString();
//                date = date.substring(0,4)+'/'+date.substring(5,7)+'/'+date.substring(8);                
//                java.util.Date myDate = new java.util.Date(date);
//                java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
  
         
//         ServiceAnimal sera = new ServiceAnimal();
         ServiceCommande ser = new ServiceCommande();
        
//
//        Animal p1 = new Animal(1,"bear","winter","bizerte");
//        Commande p2 = new Commande("bow",2020/02/02, 1, 65.2, 0);
//        
//        try {
////         
//            sera.ajouter(p1);
//            ser.ajouter(p2);
//            
//            List<Animal> lista = sera.readAll();
            List<Commande> listc = ser.readAll();
//            System.out.println(lista);
            System.out.println(listc);
        
    }
}
