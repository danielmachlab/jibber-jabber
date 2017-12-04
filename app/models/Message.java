package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This is the model representing a message. It is a ManyToOne relationship
 * to a Chat object. Each Message has a String msg representing the message content.
 * Message objects are created upon hitting send
 */
@Entity
@Table(name = "\"message\"")
public class Message extends Model {

    /**
     * The content of the message
     */
    public String msg;

    /**
     * The chat object this message belongs to
     */
    @ManyToOne
    public Chat chat;

    /**
     * Creates a new Message object
     * @param msg the content of the message
     * @param chat the Chat entity the that this Message belongs to
     */
    public Message(String msg, Chat chat){
        this.msg = msg;
        this.chat = chat;
    }
}
