package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void login(String username, String password) {
        // get user from db
        User ted = new User("ted", "paulsen", "tedpaulsen", "passw0rd");
        ted.save();
        List<User> userList = User.find("byUsernameAndPassword", "tedpaulsen", "passw0rd").fetch();

        if (userList.size() == 1) {
            System.out.println("found user");
            chat( userList.get(0) );
        } else {
            System.out.println("couldn't find user");
            index();
        }

    }

    public static void signup(String firstName, String lastName, String username, String passwd) {
        // create user in db
        User newUser = new User(firstName, lastName, username, passwd);
        newUser.save();
        chat(newUser);
    }

    public static void chat( User usr ) {
        render();
    }

}