package me.codaline.dao;

import me.codaline.model.WallEntry;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yurik on 22.05.16.
 */
@Repository
@Transactional
public class WallDao {

    @Autowired
    SessionFactory sessionFactory;

    public void saveWallEntry(WallEntry entry){sessionFactory.getCurrentSession().save(entry);}

    public List<WallEntry> getEntries(int userId){
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(WallEntry.class)
                .add(Restrictions.eq("userId", userId));

        return criteria.list();

    }
}
