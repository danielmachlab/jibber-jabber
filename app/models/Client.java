package models;

import org.apache.commons.collections.set.SynchronizedSet;
import play.mvc.Http;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Client {

    public String username;
    public String chatID;
    public Http.Outbound outbound;

    /**
     * Set of all active clients via websocket to our application
     */
    public static Set<Client> clients = Collections.synchronizedSet(new HashSet<Client>());

    public Client(Http.Outbound ob, String username) {
        outbound = ob;
        this.username = username;
        this.clients = Collections.synchronizedSet(clients);
    }
}
