package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        // (?=.*[0-9]) a digit must occur at least once
        //(?=.*[a-z]) a lower case letter must occur at least once
        //(?=.*[A-Z]) an upper case letter must occur at least once
        //.{8,} at least 8 characters
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
        if (!password.matches(pattern)){
            badRequest();
        }
        
        User u = new User(username, HashUtils.getMd5(password), type, -1);
        u.save();
        registerComplete();
    }

    public static void registerComplete(){
        render();
    }
}
