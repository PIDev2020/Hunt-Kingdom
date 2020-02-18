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
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class Test {
     public static void main(String[] args) throws ParseException {
        
         ServiceAnimal sera = new ServiceAnimal();
         ServiceCommande ser = new ServiceCommande();
        

        Animal p1 = new Animal(1,"bear","winter","bizerte");
        Commande p2 = new Commande("arc","10-02-2020", 2);
        
        try {
//         
            sera.ajouter(p1);
            ser.ajouter(p2);
            
            List<Animal> lista = sera.readAll();
            List<Commande> listc = ser.readAll();
            System.out.println(lista);
            System.out.println(listc);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
