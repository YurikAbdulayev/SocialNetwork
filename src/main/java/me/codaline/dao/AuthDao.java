package me.codaline.dao;

import me.codaline.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class AuthDao {

    @Autowired
    SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
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

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
