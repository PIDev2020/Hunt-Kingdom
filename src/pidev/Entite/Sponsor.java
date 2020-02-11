/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author USER
 */
public class Sponsor {
    int idSponsor;
    String nom;
    int idEvent;
    int confirmation ;
    

    public Sponsor() {
    }

    public Sponsor(int idSponsor, String nom, int idEvent, int confirmation) {
        this.idSponsor = idSponsor;
        this.nom = nom;
        this.idEvent = idEvent;
        this.confirmation = confirmation;
        
    }

   
    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return nom;
    }

    public void setIdUser(String nom) {
        this.nom = nom;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void getIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    

    @Override
    public String toString() {
        return "Sponsor{" + "idSponsor=" + idSponsor + ", nom=" + nom + ", idEvent=" + idEvent + ", confirmation=" + confirmation  + '}';
    }
    
    
    
    
    
    
}
