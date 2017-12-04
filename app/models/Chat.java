package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class Chat extends Model {

    @ManyToMany
    public Set<User> members;

    @OneToMany
    public List<Message> messages;

    public Chat(Set<User> users) {
        this.members = users;
        messages = new LinkedList<>();
    }


}
