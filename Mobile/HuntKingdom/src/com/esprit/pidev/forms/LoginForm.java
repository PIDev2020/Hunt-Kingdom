/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.pidev.services.UsersService;
import com.esprit.pidev.utils.CurrentUser;

/**
 *
 * @author Testouri Mohamed
 */
public class LoginForm extends Form {

    UsersService US = new UsersService();
    CurrentUser CU = new CurrentUser();

    public LoginForm() {
        super("Login", BoxLayout.y());
        TextField emailTF = new TextField(null, "E-mail", 20, TextField.ANY);
        TextField passwordTF = new TextField(null, "Password", 20, TextField.PASSWORD);
        Button loginBTN = new Button("Login");
        Button registerBTN = new Button("Create an account ?");
        boolean res;

        loginBTN.addActionListener((evt) -> {

            if ((emailTF.getText().length() != 0) && (passwordTF.getText().length() != 0)) {
                if (emailTF.getText().length() != 0) {
                    if (passwordTF.getText().length() >= 0) {
                        boolean check = US.checkLogin(emailTF.getText(), passwordTF.getText());
                        if (check) {
                            CU.setIdCurrentUser(US.getUser(emailTF.getText(), passwordTF.getText()).get(0).getId());
                            CU.setCurrentUser(US.getUser(emailTF.getText(), passwordTF.getText()).get(0));
                            Dialog.show("Hunt Kingdom", "Welcome Back " + CU.getCurrentUser().getUsername()+ " !", "Thank you !", null);
                            new Home().show();
                        }
                    } else {
                        Dialog.show("Alert", "Password is invalid!", "Ok", null);
                    }
                } else {
                    Dialog.show("Alert", "E-mail is invalid!", "Ok", null);
                }
            } else {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);
            }
        });
      //  registerBTN.addActionListener((evt) -> new RegisterForm().show());

        this.addAll(emailTF, passwordTF, loginBTN, registerBTN);
    }

}
