/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Commande {
    private int idCommande;
    private String date;
    private int idUser;

    public Commande(int idCommande, String date, int idUser) {
        this.idCommande = idCommande;
        this.date = date;
        this.idUser = idUser;
    }

    public Commande() {
    }

    public Commande(int idCommande, int idUser) {
        this.idCommande = idCommande;
        this.idUser = idUser;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public String getDate() {
        return date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + idCommande + ", date=" + date + ", idUser=" + idUser + '}';
    }
     
    
}
