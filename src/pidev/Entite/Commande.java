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
    private String produit;
    private String date;
    private int idUser;
    private float price;
    private int state;

    public Commande(int idCommande, String produit, String date, int idUser, float price, int state) {
        this.idCommande = idCommande;
        this.produit = produit;
        this.date = date;
        this.idUser = idUser;
        this.price = price;
        this.state = state;
    }
    
    

    public Commande(String produit, String date, int idUser, float price, int state) {
        this.produit = produit;
        this.date = date;
        this.idUser = idUser;
        this.price = price;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
   

    
    public Commande(String produit, String date, int idUser, float price) {
        this.produit = produit;
        this.date = date;
        this.idUser = idUser;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

    public Commande(int idCommande, String produit, String date, int idUser) {
        this.idCommande = idCommande;
        this.produit = produit;
        this.date = date;
        this.idUser = idUser;
    }

    
    
    public Commande(String produit, String date, int idUser) {
        this.produit = produit;
        this.date = date;
        this.idUser = idUser;
    }

    public Commande() {
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
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
        return "Commande{" + "idCommande=" + idCommande + ", produit=" + produit + ", date=" + date + ", idUser=" + idUser + '}';
    }

    
    
}
