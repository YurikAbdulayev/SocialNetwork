package me.codaline.service;

import me.codaline.dao.TestUserDao;
import me.codaline.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    TestUserDao dao;

    public TestUser createUser(String firstName, String lastName, String email) {
        TestUser testUser = new TestUser();
        testUser.setLastName(lastName);
        testUser.setFirstName(firstName);
        testUser.setEmail(email);
        testUser.setPass(generatePass());
        dao.save(testUser);
        return testUser;
    }

    public List<TestUser> getUsers() {
            return dao.getUsers();
    }

    public TestUser getUser(String email) {
        return dao.getUser(email);
    }

    private String generatePass() {
        return "myGeneratedPass"; //TODO generate random email!!!!
    }
}
