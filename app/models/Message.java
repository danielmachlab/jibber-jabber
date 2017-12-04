package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"message\"")
public class Message extends Model {

    public String msg;

    @ManyToOne
    public Chat chat;

    public Message(String msg){
        this.msg = msg;
    }
}
