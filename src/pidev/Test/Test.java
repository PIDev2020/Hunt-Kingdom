/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test;

import java.sql.SQLException;
import pidev.Entite.Groups;
import pidev.Entite.Users;
import pidev.Service.GroupService;
import pidev.Service.UserService;

/**
 *
 * @author elhak
 */
public class Test {

    public static void main(String[] args) throws SQLException {
//        ServiceAnnonce SA = new ServiceAnnonce();
        UserService US = new UserService();
        GroupService GS = new GroupService();
//        Annonce a1 = new Annonce(123, "Cication du jour", " Pour être appréciée à sa juste valeur une randonnée pédestre devrait être entreprise seul. La marche à plusieurs, ou même à deux, n’a plus de randonnée que le nom ; c’est quelque chose d’autre, qui ressemble à un pique-nique. Une randonnée pédestre devrait être entreprise seul, parce que la liberté en est l’essence.", 456);
//        Annonce a2 = new Annonce(789, "Bon plan !! ", " voici une liste de bon plans qu'on a voulu partager avec vous ! ", 1011);
//
//        Annonce a4 = new Annonce(12, "updated ", "yeaaaaaas ! ", 1314);

        Users u1 = new Users("Mohamed", "Testouri", 22222860, 1, "mohamed.testouri@esprit.tn", "HelloJava");
        Users u2 = new Users("test2", "test", 860, 0, "mohamed@esprit.tn", "HelloJava");
        Groups g1 = new Groups("Test 1", "jaw");
        Groups g2 = new Groups("TEst", "teST");
        US.add(u2);
        US.add(u1);
        GS.add(g1);
        GS.add(g2);
        
        //US.delete("mohamed.testouri@esprit.tn");
//        try {
//            
//          /*SA.ajouter1(a2);
//            SA.ajouter1(a1);
//            
//            
//            
//            SA.ajouter1(a4);    */         //works perfectly
//            
//            //SA.delete(7);                 //works perfectly
//            
//            //SA.update(a4, 7);             //works perfectly
//            
//            List<Annonce> list = SA.readAll();
//            System.out.println(list);
//            
//           
//            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
    }

}
