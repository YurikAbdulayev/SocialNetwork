package me.codaline.dao;

import me.codaline.model.TestUser;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TestUserDao {

    @Autowired
    SessionFactory sessionFactory;

    public void save(TestUser testUser) {
        sessionFactory.getCurrentSession().save(testUser);
    }

    public List<TestUser> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(TestUser.class).list();
    }

    public TestUser getUser(String email) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TestUser.class);
        criteria.add(Restrictions.eq("email", email));
//        Query query = sessionFactory.getCurrentSession().createQuery("select from TestUser as u where u.email =:email");
//        query.setParameter("email", email);
        return (TestUser) criteria.uniqueResult();
    }
}
