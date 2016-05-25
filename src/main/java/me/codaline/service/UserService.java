package me.codaline.service;

import me.codaline.dao.EditProfileDao;
import me.codaline.dao.UserDao;
import me.codaline.model.Friends;
import me.codaline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    @Autowired
    EditProfileDao profileDao;



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

    public Friends addToFriend(Friends friends){
        Friends friends1 = new Friends(friends.getFriendId(), friends.getUserId());
        dao.addToFriend(friends);
        dao.addToFriend(friends1);
        return friends;
    }

    public List<User> getFrinds(int userId){
        return dao.getFriendsList(userId);
    }

    public void deleteFriends(int userId, int friendId){
        dao.deleteFriend(userId, friendId);
    }

    public boolean isFriends(int userId, int friendId){
        return dao.isFriends(userId, friendId);
    }

    public User updateUser(String name, String surname, String nick, String birth, String mail, String pass,
                           String city, String phone, String interests, String citations, String about,
                           String hobby, String books, String films, User user, int id) {
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
        dao.updateUser(user);
        return user;
    }

    public void updatePhoto(int userId, String path){
        profileDao.updatePhotoUser(userId, path);
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

    public User getUserToId(int id) {
        return dao.getUserToId(id);
    }

}
