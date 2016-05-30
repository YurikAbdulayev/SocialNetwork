package me.codaline.dao;

import me.codaline.model.Friends;
import me.codaline.model.Images;
import me.codaline.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void addImage(byte[] img, int userId){
        Images images = new Images();
        images.setId(userId);
        images.setImage(img);
        sessionFactory.getCurrentSession().saveOrUpdate(images);
    }

    public void addToFriend(Friends friends) {
        sessionFactory.getCurrentSession().save(friends);
    }

    public void deleteFriend(int userId, int friendId) {
        Friends friends = new Friends(userId, friendId);
        Friends friends1 = new Friends(friendId, userId);
        sessionFactory.getCurrentSession().delete(friends);
        sessionFactory.getCurrentSession().delete(friends1);
    }

    public boolean isFriends(int userId, int friendId) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Friends.class)
                .add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("friendId", friendId));
        Friends friends = (Friends) criteria.uniqueResult();
        return friends != null;
    }

    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public List<Friends> getFriendsId(int userId) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Friends.class)
                .add(Restrictions.eq("userId", userId))
                .list();
    }

    public List<User> getFriendsList(int userId) {
        List<User> users = new ArrayList<User>();
        List<Friends> friends = getFriendsId(userId);
        for (int i = 0; i < friends.size(); i++) {
            users.add(getUserToId(friends.get(i).getFriendId()));
        }
        return users;
    }

    public User getUser(String login, String pass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("pass", pass));
//        Query query = sessionFactory.getCurrentSession().createQuery("select from User as u where u.email =:email");
//        query.setParameter("email", email);
        User user = (User) criteria.uniqueResult();
        user.setToken(generateToken());
        return user;
    }

    public User getUser(String token) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("token", token));
        return (User) criteria.uniqueResult();
    }

    public User getUserToId(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
