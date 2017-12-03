package controllers;

import models.Client;
import play.exceptions.JavaExecutionException;
import play.mvc.Http;
import play.mvc.WebSocketController;
import play.libs.F.*;

import javax.mail.Session;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */

    public static void socket(String name) {
        outbound.send("hello %s!", name);
    }

    public static void messengerSocket(String username) {

        System.out.println(username);
        outbound.send("You are now connected to the jat!");
        Client.connections.add(new Client(outbound, username));

        try {
            while (inbound.isOpen()) {
                Http.WebSocketEvent e = await(inbound.nextEvent());

                if (e instanceof Http.WebSocketFrame) {
                    String senderUsername = ((Http.WebSocketFrame) e).textData.split(":")[0];
                    String message = ((Http.WebSocketFrame) e).textData.split(":")[1];

                    for (Client clients : Client.connections) {
                        if (!(clients.username.equals(senderUsername))) {
                            clients.outbound.send(senderUsername + ": " + message);
                        }
                    }
                }
            }

            outbound.send("inbound closed");
            System.out.println("inbound closed");
        }catch(JavaExecutionException e){
            System.out.println("this is the problem");
        }catch (Exception e){
            System.out.println("Class: " + e.getClass());
            for(Client clients : Client.connections) {
                if(clients.outbound.equals(outbound)){
                    Client.connections.remove(clients);
                    System.out.printf("removed: %s", clients.username);
                    disconnect();
                }
            }

        }
    }

}
