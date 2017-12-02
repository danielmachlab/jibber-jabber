package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Model {

    public String phNumber;
    public List<Chat> chatList;

    public User(String num) {
        phNumber = num;
        chatList = new LinkedList<>();

    }

}
