package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Message extends Model {

    public String msg;

    @ManyToOne
    public Chat chat;

    public Message(String msg, Chat chat){
        this.msg = msg;
        this.chat = chat;
    }
}
