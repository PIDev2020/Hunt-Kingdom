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
public class GroupUser {
    private int idGroupUser;
    private int idUser;
    private int idGroup;

    public GroupUser() {
    }

    public GroupUser(int idGroupUser, int idUser, int idGroup) {
        this.idGroupUser = idGroupUser;
        this.idUser = idUser;
        this.idGroup = idGroup;
    }

    public GroupUser(int idUser, int idGroup) {
        this.idUser = idUser;
        this.idGroup = idGroup;
    }

    public int getIdGroupUser() {
        return idGroupUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroupUser(int idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "GroupUser{" + "idGroupUser=" + idGroupUser + ", idUser=" + idUser + ", idGroup=" + idGroup + '}';
    }
    
}
