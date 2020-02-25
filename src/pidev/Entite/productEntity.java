/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

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
    User owner= new User();
    String username;
    String lastname;

    public String getUsername() {
        return owner.getName();
    }

    

    public String getLastname() {
        return owner.getLastname();
    }

    
    
    
    

    public productEntity() {
    }

    public productEntity(int IdProduct, String Name, String Description, String Photo, float Price, User u) {
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Price = Price;
        this.owner = u;
    }

    public productEntity(String Name, String Description, String Photo, float Price, User u) {
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Price = Price;
        this.owner = u;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "productEntity{" + "IdProduct=" + IdProduct + ", Name=" + Name + ", Description=" + Description + ", Photo=" + Photo + ", Price=" + Price + ", owner=" + owner + '}';
    }
   
    
    

   
    
    
}
