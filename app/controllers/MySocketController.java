package controllers;

import models.Client;
import play.mvc.Http;
import play.mvc.WebSocketController;

import javax.mail.Session;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */

    public static void socket(String name) {
        outbound.send("hello %s!", name);
    }

    public static void messengerSocket() {
        outbound.send("You are now connected to the jat!");
        Client.connections.add(new Client(outbound));

        while(inbound.isOpen()){
            Http.WebSocketEvent e = await(inbound.nextEvent());

            if(e instanceof Http.WebSocketFrame) {
                String senderUsername = ((Http.WebSocketFrame)e).textData.split(":")[0];
                String message = ((Http.WebSocketFrame)e).textData.split(":")[1];

                for (Client clients : Client.connections) {
                    if (clients.username != senderUsername) {
                        clients.outbound.send(message);
                    }
                }
            }

        }

        outbound.send("inbound closed");
        System.out.println("inbound closed");
    }

}
