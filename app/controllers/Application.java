package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

/**
 *
 */
public class Application extends Controller {


    /**
     *
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
}