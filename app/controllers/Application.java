package controllers;

import jobs.Start;
import play.libs.F;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {


    public static void index() {
        render();
    }

    public static void chat(String username, String chatId) {
        Chat chat = (Chat) Chat.find("byChatId", chatId).fetch().get(0);
        List<Message> messages = chat.messages;

        render(username, messages);
    }

    public static void doJob() {
        System.out.println("Starting chat job");
        new Start().now();
        System.out.println("Done with chat job");
    }
}