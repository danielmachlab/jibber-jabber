package controllers;

import play.mvc.Http;
import play.mvc.WebSocketController;

import static play.libs.F.Matcher.ClassOf;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */

    public static void socket(String name) {
        outbound.send("hello %s!", name);
    }

    public static void messengerSocket(String name){
        outbound.send("You are now connected to the chat!");

        while(inbound.isOpen()){

            Http.WebSocketEvent e = await(inbound.nextEvent());

            if(e instanceof Http.WebSocketFrame) {
                outbound.send(((Http.WebSocketFrame) e).textData);
            }

        }
    }
}
