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
public class productEntity {
    
    int IdProduct;
    String Name;
    String Description;
    String Photo;
    float Price;
   //User IdUser = new User();
    int IdUser;

    public productEntity() {
    }

    public productEntity(String Name, String Description, String Photo, float Price, int IdUser) {
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Price = Price;
        this.IdUser = IdUser;
    }

    public productEntity(int IdProduct, String Name, String Description, String Photo, float Price, int IdUser) {
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Price = Price;
        this.IdUser = IdUser;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int IdProduct) {
        this.IdProduct = IdProduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "productEntity{" + "IdProduct=" + IdProduct + ", Name=" + Name + ", Description=" + Description + ", Photo=" + Photo + ", Price=" + Price + ", IdUser=" + IdUser + '}';
    }
    
    
    
    
    
}
