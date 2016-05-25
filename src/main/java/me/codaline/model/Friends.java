package me.codaline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yurik on 24.05.16.
 */
@Entity
public class Friends {

    @Id
    @GeneratedValue
    int id;
    int userId;
    int friendId;

    public Friends() {
    }

    public Friends(int userId, int friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public int getUserId() {
        return userId;
    }

    public int getFriendId() {
        return friendId;
    }
}
