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
        List<User> userList = User.find("byUsernameAndPassword", username, password).fetch();

        if (userList.size() == 1) {
            System.out.println("found user");
            User user = userList.get(0);
            chat(user.userName);
        } else {
            System.out.println("couldn't find user");
            index();
        }
    }

    public static void signup(String firstName, String lastName, String username, String password) {
        // create user in db
        User newUser = new User(firstName, lastName, username, password);
        newUser.save();

        // render chat page for this username
        chat(newUser.userName);
    }

    public static void chat( String username ) {
        User user = (User) User.find("byUsername", username).fetch().get(0);
        List<Chat> chats = user.chats;

        render(user, chats);
    }
}