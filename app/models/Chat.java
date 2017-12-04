package models;

import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity for the chats
 */
@Entity
public class Chat extends GenericModel {

    /**
     * Primary Key
     */
    @Id
    public String chatId;

    /**
     *
     */
    @OneToMany
    public List<Message> messages;

    /**
     * Constructor
     * @param id the chat id
     */
    public Chat(String id) {
        chatId = id;
        messages = new LinkedList<>();
    }

}
