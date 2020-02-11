/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Event {
    int idEvent;
    int idUser;
    String titre;
    int nbrplaces ;
    String localisation ;
   
    float hdebut ;
    float hfin ;
    float prix ;

    public Event() {
    }

    public Event(int idEvent, int idUser, String titre, int nbrplaces, String localisation, float hdebut, float hfin, float prix) {
        this.idEvent = idEvent;
        this.idUser = idUser;
        this.titre = titre;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
    }

   
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(int nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public float getHdebut() {
        return hdebut;
    }

    public void setHdebut(float hdebut) {
        this.hdebut = hdebut;
    }

    public float getHfin() {
        return hfin;
    }

    public void setHfin(float hfin) {
        this.hfin = hfin;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Event{" + "idEvent=" + idEvent + ", idUser=" + idUser + ", titre=" + titre + ", nbrplaces=" + nbrplaces + ", localisation=" + localisation +  ", hdebut=" + hdebut + ", hfin=" + hfin + ", prix=" + prix + '}';
    }
    
    
    
    
    
    
}
