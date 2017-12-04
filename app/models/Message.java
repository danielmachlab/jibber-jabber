package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Message extends Model {

    public LocalDateTime timestamp;
    public User sender;

    @ManyToOne
    public Chat chat;
    public String content;

    public Message(User from, String content, Chat chat) {
        this.sender = from;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.chat = chat;
    }

}
