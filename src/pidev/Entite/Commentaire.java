/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;


public class Commentaire {
    private int idCommentaire;
    private int idCommentaireRS;
    private int idUser;
    private int idAnnonceRS;
    private String champCommentaire;
    private String dateCommentaire;

    public Commentaire() {
    }

    public Commentaire(int idUser, String champCommentaire, String dateCommentaire) {
        this.idUser = idUser;
        this.champCommentaire = champCommentaire;
        this.dateCommentaire = dateCommentaire;
    }

    public Commentaire(int idUser,int idAnnonceRS, String champCommentaire) {
        this.idUser = idUser;
        this.idAnnonceRS = idAnnonceRS;
        this.champCommentaire = champCommentaire;
        
    }
           
    
    
    public Commentaire(int idUser,int idAnnonceRS,int idCommentaireRS, String champCommentaire) {
        this.idUser = idUser;
        this.idAnnonceRS = idAnnonceRS;
        this.idCommentaireRS = idCommentaireRS;
        this.champCommentaire = champCommentaire;
    }

    public Commentaire(int idCommentaire, int idCommentaireRS, int idUser, int idAnnonceRS , String champCommentaire, String dateCommentaire) {
        this.idCommentaire = idCommentaire;
        this.idCommentaireRS = idCommentaireRS;
        this.idUser = idUser;
        this.idAnnonceRS = idAnnonceRS;
        this.champCommentaire = champCommentaire;
        this.dateCommentaire = dateCommentaire;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getIdCommentaireRS() {
        return idCommentaireRS;
    }

    public void setIdCommentaireRS(int idCommentaireRS) {
        this.idCommentaireRS = idCommentaireRS;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAnnonceRS() {
        return idAnnonceRS;
    }

    public void setIdAnnonceRS(int idAnnonce) {
        this.idAnnonceRS = idAnnonce;
    }

    public String getChampCommentaire() {
        return champCommentaire;
    }

    public void setChampCommentaire(String champCommentaire) {
        this.champCommentaire = champCommentaire;
    }

    public String getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(String dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", idCommentaireRS=" + idCommentaireRS + ", idUser=" + idUser + ", idAnnonceRS=" + idAnnonceRS + ", champCommentaire=" + champCommentaire + ", dateCommentaire=" + dateCommentaire + '}';
    }

    
    
    
    
    
}
