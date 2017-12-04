package models;

import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "\"chat\"")
public class Chat extends GenericModel {

    @Id
    public String chatId;

    @OneToMany
    public List<Message> messages;

    public Chat(String id) {
        chatId = id;
        messages = new LinkedList<>();
    }

}
