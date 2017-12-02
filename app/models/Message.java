package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Message extends Model {

    public LocalDateTime timestamp;
    public User sender;
    public Chat chat;
    public String content;

    public Message(User from, Chat thread) {
        sender = from;
        chat = thread;
    }

}
