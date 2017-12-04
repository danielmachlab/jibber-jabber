package controllers;

import models.Client;
import play.exceptions.JavaExecutionException;
import play.mvc.Http;
import play.mvc.WebSocketController;

import java.util.Iterator;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */

    public static void socket(String name) {
        outbound.send("hello %s!", name);
    }

    public static void messengerSocket(String username) {
//        Iterator<String> x = WebSocketController.session.all().keySet().iterator();
//        while (x.hasNext()){
//            System.out.println(x.next());
//        }
        System.out.println(username);
        outbound.send("You are now connected to the jat!");
        Client.clients.add(new Client(outbound, username));

        try {
            while (inbound.isOpen()) {
                Http.WebSocketEvent e = await(inbound.nextEvent());

                if (e instanceof Http.WebSocketFrame) {
                    String senderUsername = ((Http.WebSocketFrame) e).textData.split(":")[0];
                    String message = ((Http.WebSocketFrame) e).textData.split(":")[1];


//                    User sender = (User) User.find("byUsername", username).fetch().get(0);
//                    Chat chat = ((User) User.find("byUsername", username).fetch().get(0)).chats.get(0);
//                    Message msg = new Message(sender, message, chat);
//                    msg.save();

                    for (Client clients : Client.clients) {
                        clients.outbound.send(senderUsername + ": " + message);
                        System.out.printf("Server received message: %s From User: %s\n", message, senderUsername);
//                        if (!(clients.username.equals(senderUsername))) {
//                            clients.outbound.send(senderUsername + ": " + message);
//                        }else{
//                            System.out.printf("Server received message: %s From User: %s\n", message, senderUsername);
//                        }
                    }
                }
            }

            outbound.send("inbound closed");
            System.out.println("inbound closed");
        } catch (JavaExecutionException e) {
            System.out.println("this is the problem");
        } catch (Exception e) {
            System.out.println("Class: " + e.getClass());
            try {
                Client removeMe = null;
                for (Client clients : Client.clients) {
                    if (clients.outbound.equals(outbound)) {
                        removeMe = clients;
                        System.out.printf("removed: %s", clients.username);
                    }
                }
                Client.clients.remove(removeMe);
            } catch (JavaExecutionException exx) {
                exx.getErrorDescription();
            }


        }
    }

    public static void printClients(){
        Iterator<Client> x = Client.clients.iterator();
        System.out.println("------------\nCurrent connected clients: ");
        while(x.hasNext()){
            System.out.println(x.next().username);
        }
        System.out.println("------------");
    }

}
