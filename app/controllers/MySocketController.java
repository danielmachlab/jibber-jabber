package controllers;

import play.mvc.Http;
import play.mvc.WebSocketController;

import javax.mail.Session;

import java.util.Set;

import static play.libs.F.Matcher.ClassOf;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */

    public static void socket(String name) {
        outbound.send("hello %s!", name);
    }

    public static void messengerSocket(Session session){
        outbound.send("You are now connected to the chat!");
        Set<Session> allSessions;

        while(inbound.isOpen()){

            Http.WebSocketEvent e = await(inbound.nextEvent());

            if(e instanceof Http.WebSocketFrame) {
                //we need to make a for loop to send to all connected clients aka group chat members

                outbound.send("Server: " + ((Http.WebSocketFrame) e).textData);
            }

        }
    }

}
