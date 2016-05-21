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

    public User createUser(String login, String password, String email, String firstName, String lastName) {
        User user = new User();
        user.setLogin(login);
        user.setPass(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        dao.save(user);
        return user;
    }

    public User saveUser(String name,
                         String surname,
                         String nick,
                         String birth,
                         String mail,
                         String pass,
                         String city,
                         String phone,
                         String interests,
                         String citations,
                         String about,
                         String hobby,
                         String books,
                         String films,
                         User user,
                         int id) {
        user.setId(id);
        user.setFirstName(name);
        user.setLastName(surname);
        user.setNick(nick);
        user.setBirth(birth);
        user.setEmail(mail);
        user.setPass(pass);
        user.setCity(city);
        user.setPhone(phone);
        user.setInterests(interests);
        user.setCitation(citations);
        user.setAbout(about);
        user.setHobby(hobby);
        user.setBooks(books);
        user.setFilms(films);
        dao.update(user);
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
