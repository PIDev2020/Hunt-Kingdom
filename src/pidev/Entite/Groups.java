/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Objects;

/**
 *
 * @author Testouri Mohamed
 */
public class Groups {
    private int idGroup;
    private String nameGroup;
    private String typeGroup;

    public Groups(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Groups() {
    }

    public Groups(int idGroup, String nameGroup, String typeGroup) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.typeGroup = typeGroup;
    }

    public Groups(String nameGroup, int idGroup) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
    }

    public Groups(String nameGroup, String typeGroup) {
        this.nameGroup = nameGroup;
        this.typeGroup = typeGroup;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getTypeGroup() {
        return typeGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }

    @Override
    public String toString() {
        return "Groups{" + "idGroup=" + idGroup + ", nameGroup=" + nameGroup + ", typeGroup=" + typeGroup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Groups other = (Groups) obj;
        if (!Objects.equals(this.nameGroup, other.nameGroup)) {
            return false;
        }
        if (!Objects.equals(this.typeGroup, other.typeGroup)) {
            return false;
        }
        return true;
    }
    
}
