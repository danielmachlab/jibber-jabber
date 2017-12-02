package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User extends Model {

    public String phNumber;
    public String userName;

    @OneToMany
    public List<Chat> chats;

    public User(String num, String name) {
        phNumber = num;
        userName = name;
        chats = new LinkedList<>();
    }

}
