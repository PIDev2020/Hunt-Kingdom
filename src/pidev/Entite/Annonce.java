/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;


public class Annonce {
    private int idAnnonce;
    private int idAnnonceRS;
    private String nomAnnonce;
    private String descriptionAnnonce;
    private int idUser;

    public Annonce() {
    }
    
    //add fxml
    public Annonce(String nomAnnonce, String descriptionAnnonce) {
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }

    //ajout fxml
    public Annonce(int idAnnonceRS, String nomAnnonce, String descriptionAnnonce) {
        this.idAnnonceRS = idAnnonceRS;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }
    
    

    public Annonce(int idAnnonce, int idAnnonceRS, String nomAnnonce, String descriptionAnnonce, int idUser) {
        this.idAnnonce = idAnnonce;
        this.idAnnonceRS = idAnnonceRS;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
        this.idUser = idUser;
    }

    public Annonce(int idAnnonceRS, int idUser, String nomAnnonce, String descriptionAnnonce) {
        this.idAnnonceRS = idAnnonceRS;
        this.idUser = idUser;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public int getIdAnnonceRS() {
        return idAnnonceRS;
    }

    public void setIdAnnonceRS(int idAnnonceRS) {
        this.idAnnonceRS = idAnnonceRS;
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
        return "Annonce{" + "idAnnonce=" + idAnnonce + ", idAnnonceRS=" + idAnnonceRS + ", nomAnnonce=" + nomAnnonce + ", descriptionAnnonce=" + descriptionAnnonce + ", idUser=" + idUser + '}';
    }
    
    
    

    
}
