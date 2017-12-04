package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Message extends Model {

    public String msg;

    public Message(String msg){
        this.msg = msg;
    }
}
