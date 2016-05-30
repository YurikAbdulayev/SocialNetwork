package me.codaline.service;

import me.codaline.dao.SearchDao;
import me.codaline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yurik on 29.05.16.
 */
@Service
public class SearchService {

    @Autowired
    SearchDao searchDao;

    public List<User> searchUsers(String s){
        return searchDao.searchUsers(s);
    }
}
