package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class Chat extends Model {

    @OneToMany
    public Set<User> members;

    @OneToMany
    public List<Message> messages;

    public static Chat onlyChat = new Chat(new HashSet<>());

    public Chat(Set<User> jibberJabberers) {
        members = jibberJabberers;
        messages = new LinkedList<>();
    }


}
