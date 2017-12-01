package models;

import play.db.jpa.Model;

import java.util.List;

public class User extends Model {

    public long phNumber;
    public String userId;
    public List<String> chats;

}
