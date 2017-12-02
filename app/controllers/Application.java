package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void chat(int phoneNumber) {
//        // Check db for user already exists
//        User user = User.findById(phNumber);
//
//        // if new user,
//        // create new User obj and save
//        if (user == null) {
//            user = new User(phNumber);
//            user.save();
//        }
//
//
//
//
//                // add user to chat room
//                // render messeges
        System.out.println(phoneNumber);
        render();
    }

}