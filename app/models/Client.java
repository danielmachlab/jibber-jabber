package models;

import play.mvc.Http;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Client {

    /**
     * Client username
     */
    public String username;
    /**
     * The chat name that client belongs to
     */
    public String chatID;
    /**
     * The WebSocket outbound object required to stream data to that individual client
     */
    public Http.Outbound outbound;

    /**
     * Set of all active clients via websocket to our application
     */
    public static Set<Client> clients = Collections.synchronizedSet(new HashSet<Client>());

    /**
     * Creates a new Client object
     * @param ob Http.Outbound object to stream data to client
     * @param username client username
     * @param chatId name of chat client belongs to
     */
    public Client(Http.Outbound ob, String username, String chatId) {
        outbound = ob;
        this.username = username;
        this.clients = Collections.synchronizedSet(clients);
        this.chatID = chatId;
    }
}
