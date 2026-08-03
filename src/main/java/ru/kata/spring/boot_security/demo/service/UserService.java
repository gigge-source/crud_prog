package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

    void saveUser(String name, String surname, Long age, String email);

    void updateUser(Long id, String name, String surname, Long age, String email);

    User findByEmail(String email);

}
