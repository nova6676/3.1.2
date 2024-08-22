package ru.kata.spring.boot_security.demo.Servis;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserInter {
    void save(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    void update(User user);
}
