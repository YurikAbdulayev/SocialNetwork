package me.codaline.service;

import me.codaline.dao.AuthDao;
import me.codaline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthDao dao;

    public User createUser(String login, String password, String email) {
        User user = new User();
        user.setLogin(login);
        user.setPass(password);
        user.setEmail(email);
        dao.save(user);
        return user;
    }

    public List<User> getUsers() {
            return dao.getUsers();
    }

    public User getUser(String login, String pass) {
        return dao.getUser(login, pass);
    }

    public User getUser(String token) {
        return dao.getUser(token);
    }

}
