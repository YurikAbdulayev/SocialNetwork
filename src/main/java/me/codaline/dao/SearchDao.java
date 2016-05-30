package me.codaline.dao;

import me.codaline.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yurik on 29.05.16.
 */
@Repository
@Transactional
public class SearchDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<User> searchUsers(String searchCriteria) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.like("firstName", "%" + searchCriteria + "%"));

        return criteria.list();
    }
}
