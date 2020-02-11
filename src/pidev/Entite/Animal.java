/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author hp
 */
public class Animal {
    
    private int idAnimal ;
    private String race ;
    private String saison ;
    private String place ;

    public Animal(int idAnimal, String race, String saison, String place) {
        this.idAnimal = idAnimal;
        this.race = race;
        this.saison = saison;
        this.place = place;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", race=" + race + ", saison=" + saison + ", place=" + place + '}';
    }
    
    
    
}
