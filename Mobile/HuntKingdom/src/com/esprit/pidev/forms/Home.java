/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.components.ImageViewer;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.net.URISyntaxException;


/**
 *
 * @author fakhreddine
 */
public class Home extends Form{

    private Form fLogin, fSeason, fAnimal, fCommande;
    private Resources theme; 
    public Home() {
        super();
        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle("HuntKingdom");

        

        this.getToolbar().addCommandToRightBar("LogOut", null, (evt) -> {
            fLogin.show();
        });
        
        this.getToolbar().addCommandToLeftSideMenu("Home", null, (evt) -> {
            
        });
         
        this.getToolbar().addCommandToLeftSideMenu("Animals", null, (evt) -> {
            try {
                new FormAnimal(this).show();
            } catch (URISyntaxException ex) {
               
            } catch (IOException ex) {
                
            }
        });
        
        this.getToolbar().addCommandToLeftSideMenu("Seasons", null, (evt) -> {
            try {
                new FormSeason(this).show();
            } catch (URISyntaxException ex) {
   
            } catch (IOException ex) {
              
            }
        });
        this.getToolbar().addCommandToLeftSideMenu("Commande", null, (evt) -> {
           new FormCommande(this).show();
        });
//        this.add(message);
    }
    
}
