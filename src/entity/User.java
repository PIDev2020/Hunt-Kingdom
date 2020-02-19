/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Dorsaf
 */
public class User {
    int IdUser;
    String name;
    String lastname;

    public User() {
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" + "IdUser=" + IdUser + ", name=" + name + ", lastname=" + lastname + '}';
    }

    
    
    
}
