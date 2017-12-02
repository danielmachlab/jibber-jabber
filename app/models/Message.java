package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "message")
public class Message extends Model {

    public LocalDateTime timestamp;
    public User sender;
    public Chat chat;

    public Message(User from, Chat thread) {
        sender = from;
        chat = thread;
    }

}
