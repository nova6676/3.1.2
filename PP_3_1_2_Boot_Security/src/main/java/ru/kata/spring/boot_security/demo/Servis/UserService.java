package ru.kata.spring.boot_security.demo.Servis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepa;


import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserInter {

    private final UserRepa userRepository;

    @Autowired
    public UserService(UserRepa userRepository) {
        this.userRepository = userRepository;
    }



    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }
}