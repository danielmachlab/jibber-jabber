package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Chat extends Model {

    public String chatId;

    @OneToMany
    public List<Message> messages;

    public Chat(String id) {
        chatId = id;
        messages = new LinkedList<>();
    }

}
