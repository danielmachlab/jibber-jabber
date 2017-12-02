package controllers;

import play.mvc.WebSocketController;

public class MySocketController extends WebSocketController {

    /**
     * this is a test for websockets
     */
    public static void socket(String name) {
        System.out.println("name is:" + name);
    }
}
