/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author Testouri Mohamed
 */
public class Annonce {
    private int idAnnonce;
    private String nomAnnonce;
    private String descriptionAnnonce;
    private int idUser;

    public Annonce() {
    }

    public Annonce(int idAnnonce, String nomAnnonce, String descriptionAnnonce, int idUser) {
        this.idAnnonce = idAnnonce;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
        this.idUser = idUser;
    }
    
    
  /*  

    public Annonce(String nomAnnonce, String descriptionAnnonce) {
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }
*/
    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getNomAnnonce() {
        return nomAnnonce;
    }

    public void setNomAnnonce(String nomAnnonce) {
        this.nomAnnonce = nomAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
       
    @Override
    public String toString() {
        return "Annonce{" + "id annonce=" + idAnnonce + ", nomAnnonce=" + nomAnnonce + ", descriptionAnnonce=" + descriptionAnnonce + ", idUser=" + idUser + '}';
    }
    
    
}
