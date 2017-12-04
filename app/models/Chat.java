package models;

import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity for the chats. The entity tag makes it persistent to the database.
 */
@Entity
@Table(name = "\"jat\"")
public class Chat extends GenericModel {

    /**
     * Primary Key of the table
     * Either 'jibber' or 'jabber'
     */
    @Id
    public String chatId;

    /**
     * The list of messages in the chat.
     */
    @OneToMany
    public List<Message> messages;

    /**
     * Constructor to initialize the chat room. Only called on app startup.
     * @param id the chat id
     */
    public Chat(String id) {
        chatId = id;
        messages = new LinkedList<>();
    }

}
