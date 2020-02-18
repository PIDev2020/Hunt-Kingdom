/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Objects;
import javafx.beans.property.IntegerProperty;

/**
 *
 * @author Testouri Mohamed
 */
public class Users {

    private int idUser;
    private String fnameUser;
    private String lnameUser;
    private int phoneUser;
    private String emailUser;
    private String passwordUser;
    private int idRole;

    public int idProperty() {
        return idUser;
    }

    public Users() {
    }

    public Users(String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.idRole = idRole;
    }

    public Users(String fnameUser, String lnameUser, int phoneUser, String emailUser, String passwordUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public Users(int idUser, String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser, String passwordUser) {
        this.idUser = idUser;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;

    }

    public Users(String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser, String passwordUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public Users(int idUser, String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser) {
        this.idUser = idUser;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
    }

    public Users(int idUser, String fnameUser, String lnameUser, int phoneUser, String emailUser) {
        this.idUser = idUser;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFnameUser() {
        return fnameUser;
    }

    public String getLnameUser() {
        return lnameUser;
    }

    public int getPhoneUser() {
        return phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public int getidRole() {
        return idRole;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setFnameUser(String fnameUser) {
        this.fnameUser = fnameUser;
    }

    public void setLnameUser(String lnameUser) {
        this.lnameUser = lnameUser;
    }

    public void setPhoneUser(int phoneUser) {
        this.phoneUser = phoneUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "Users{" + "idUser=" + idUser + ", fnameUser=" + fnameUser + ", lnameUser=" + lnameUser + ", phoneUser=" + phoneUser + ", emailUser=" + emailUser + ", idRole=" + idRole + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (!Objects.equals(this.fnameUser, other.fnameUser)) {
            return false;
        }
        if (!Objects.equals(this.lnameUser, other.lnameUser)) {
            return false;
        }
        if (!Objects.equals(this.emailUser, other.emailUser)) {
            return false;
        }
        if (!Objects.equals(this.passwordUser, other.passwordUser)) {
            return false;
        }
        return true;
    }

}
