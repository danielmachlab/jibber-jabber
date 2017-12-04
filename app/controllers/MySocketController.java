package controllers;

import models.Chat;
import models.Client;
import models.Message;
import play.exceptions.JavaExecutionException;
import play.mvc.Http;
import play.mvc.WebSocketController;

import java.util.Iterator;
import java.util.List;

/**
 * The controller to handle WebSocket requests. WebSocket requests are
 * received when a jibberer or jabberer presses send.
 */
public class MySocketController extends WebSocketController {

    /**
     * Controller method to handle websocket connections from the browser
     * @param username username of the person who logged on
     * @param clientChatID the id of the chat that person is chatting in
     */
    public static void messengerSocket(String username, String clientChatID) {

        //get the list of messages for the chat room the user just entered
        List<Message> messages = Message.findAll();

        if (!messages.isEmpty()) {
            for (Message m : messages) {
                if (m.chat.chatId.equals(clientChatID)) {
                    outbound.send(m.msg);
                }
            }
        }

        Client.clients.add(new Client(outbound, username, clientChatID));

        Chat chat = (Chat) Chat.find("byChatId", clientChatID).fetch().get(0);

        Message connectionMessage = new Message("\n" + username + " now chatting", chat);
        outbound.send(connectionMessage.msg);
        connectionMessage.save();

        try {
            while (inbound.isOpen()) {
                Http.WebSocketEvent e = await(inbound.nextEvent());

                if (e instanceof Http.WebSocketFrame) {
                    String message = ((Http.WebSocketFrame) e).textData;

                    //add message to database
                    Message messageToAdd = new Message(username + ": " + message, chat);
                    messageToAdd.save();

                    for (Client clients : Client.clients) {
                        if (clients.chatID.equals(clientChatID)) {
                            clients.outbound.send(username + ": " + message);
                            System.out.printf("Server received message: %s From User: %s\n", message, username);
                        }
                    }
                }
            }

            outbound.send("inbound closed");
            System.out.println("inbound closed");
        } catch (JavaExecutionException e) {
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

}
