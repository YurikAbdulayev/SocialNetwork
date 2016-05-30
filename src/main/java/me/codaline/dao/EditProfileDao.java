package me.codaline.dao;

import me.codaline.model.Images;
import me.codaline.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yurik on 25.05.16.
 */
@Repository
@Transactional
public class EditProfileDao {

    @Autowired
    SessionFactory sessionFactory;

    public void updatePhotoUser(int userId, String path){
        User user = (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("id", userId))
                .uniqueResult();
        user.setPathImage(path);
        sessionFactory.getCurrentSession().update(user);

    }

    public Images getImage(int userId){
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Images.class)
                .add(Restrictions.eq("id", userId));
        return (Images) criteria.uniqueResult();
    }


}
