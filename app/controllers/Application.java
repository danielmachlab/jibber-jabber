package controllers;

import jobs.Start;
import play.libs.F;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * Application HTTP request controller.
 * Handles requests mapped by routes file of type GET and POST
 */
public class Application extends Controller {

    /**
     * Handles requests to /
     * renders views.Application.index.html
     */
    public static void index() {
        render();
    }

    /**
     * Takes the username and clientChatID sent from index.html and sends that to chat.html
     * @param username the connecting user's username
     * @param clientChatID the connecting user's chat they specified to be in
     */
    public static void chat(String username, String clientChatID) {
        Chat chat = (Chat) Chat.find("byChatId", clientChatID).fetch().get(0);
        List<Message> messages = chat.messages;

        render(username, messages, clientChatID);
    }

    /**
     * Job to be executed at app start up to
     */
    public static void doJob() {
        System.out.println("Starting chat job");
        new Start().now();
        System.out.println("Done with chat job");
    }
}