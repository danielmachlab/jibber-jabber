package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User extends Model {

    public String userName;
    public String password;
    public String firstName;
    public String lastName;

    @OneToMany
    public List<Chat> chats;

    public User(String first, String last, String user, String pwd, Chat chat) {
        userName = user;
        password = pwd;
        firstName = first;
        lastName = last;

        chats = new LinkedList<>();
        chats.add(chat);
    }

}
