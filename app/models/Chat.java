package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//@Entity
//@Table(name = "chat")
public class Chat extends Model {

    public Set<User> members;
    public Queue<Message> messages;

    public Chat(List<User> jibberJabberers) {
        members.addAll(jibberJabberers);
        messages = new LinkedList<>();
    }

}
