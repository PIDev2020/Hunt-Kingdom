/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 *
 * @author hp
 */
public class signin extends Form{
     
    private Resources theme;

    TextField loginT;
    TextField pass;
    Button cnx;
    Button fb;
    String message;
    ConnectionRequest cn;

    public signin() {

     
        super();
        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle("HuntKingdom");
            //login.getUnselectedStyle().setBgColor(30);
            Container c = new Container(BoxLayout.y());
            Container c1 = new Container(BoxLayout.y());
            loginT = new TextField("", "login", 20, TextArea.ANY);

            pass = new TextField("", "password", 20, TextArea.PASSWORD);
            cnx = new Button("Se connecter");

            c.add(loginT);
            c.add(pass);
            c.add(cnx);





            this.add(c);
            this.add(c1);
            this.show();
            cnx.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    String url = "http://localhost/HuntKingdom/web/app_dev.php/login/" + loginT.getText() + "/" + pass.getText();

                    cn = new ConnectionRequest();
                    cn.setUrl(url);
                    cn.addResponseListener((e) -> {

                        String str = new String(cn.getResponseData());
                        System.out.println(str);

                    });

                    System.out.println(url);
                    //cn.setPost(false);

                    cn.addResponseListener(new ActionListener<NetworkEvent>() {
                        @Override
                        public void actionPerformed(NetworkEvent evt) {
                         
                            try {
                                message = new String(cn.getResponseData(), "utf-8");
                            } catch (UnsupportedEncodingException ex) {
                         
                            }

                                
                                    new Home().show();
      
                                    }
                              
                    });
                    NetworkManager.getInstance().addToQueueAndWait(cn);
                    System.out.println("heeeeeeeeeeeeeeeereeeeeeeeeeee");
                }

            });
            
            
//            theme = UIManager.initFirstTheme("/theme");
//            ImageViewer img = new ImageViewer();
//            img.setImage(theme.getImage("back-command.png"));
//
//            signupForm.getSignup().getToolbar().addCommandToLeftBar("Back", img.getImage(), new ActionListener<ActionEvent>() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    signupForm.getSignup().show();
//                }
//            });
        }
    
}
