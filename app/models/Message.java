package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Message extends Model {

    public LocalDateTime timestamp;
    public User user;

    @OneToOne
    public Chat chat;

    public String content;

    public Message(User from, String content, Chat chat) {
        this.user = from;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.chat = chat;
    }

}
