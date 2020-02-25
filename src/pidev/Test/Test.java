/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test;

import java.sql.SQLException;
import java.util.List;
import pidev.Entite.Annonce;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceAnnonce;
import pidev.Service.ServiceCommentaire;

/**
 *
 * @author elhak
 */
public class Test {

    public static void main(String[] args) {
        ServiceAnnonce SA = new ServiceAnnonce();
        ServiceCommentaire SC = new ServiceCommentaire();

        Annonce a1 = new Annonce(428,2,"Bon Plan ", "Annonce bon plan modifiéé ");
               
        
        
        

        Commentaire c1 = new Commentaire(2,428,25,"commentaire modifiéé");
        Commentaire c2 = new Commentaire(2,428,25,"commentaire jdiiiiddd");

        try {
            
            
            //SA.ajouter1(a1);      //(`idAnnonce`,`nomAnnonce`,`descriptionAnnonce`,`idUser`)

            //SA.update(a1,428);        
            //SA.delete(428);
            
            
            //SC.ajouter(c2);       //(`idUser`,`idAnnonce`,`idCommentaireRS`,`champCommentaire`)
            //SC.update(c1, 1);
            //SC.delete(25);
            
            List<Annonce> list = SA.readAll();
            System.out.println(list);

            List<Commentaire> listC = SC.readAll();
            System.out.println(listC);  


        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
