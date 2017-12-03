package models;

import play.mvc.Http;

import java.util.HashSet;
import java.util.Set;

public class Client {

    public String username;
    public Chat chat;
    public Http.Outbound outbound;

    /**
     * Set of all active connections via websocket to our application
     */
    public static Set<Client> connections = new HashSet<>();


    public Client(Http.Outbound ob) {
        outbound = ob;
    }
}
