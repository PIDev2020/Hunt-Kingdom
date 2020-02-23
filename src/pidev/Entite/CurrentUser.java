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
public class CurrentUser {
    private static CurrentUser instance;
    
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

     public static CurrentUser getInstance() {
         if (instance == null) {
             return instance;
         }
         return instance;
    }
     
     
    


}
