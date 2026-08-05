package ru.kata.spring.boot_security.demo.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final RoleDao roleDao;

    public DataInitializer(final UserService userService, final RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @Override
    public void run (String... args) throws Exception {

        Role role = roleDao.findByName("ROLE_ADMIN");

        if (role == null) {
            roleDao.save(new Role("ROLE_ADMIN"));
        }

        Role role2 = roleDao.findByName("ROLE_USER");
        if (role2 == null) {
            roleDao.save(new Role("ROLE_USER"));
        }

        User admin = userService.findByEmail("admin@admin.com");

        if (admin == null) {
            admin = new User("Admin", "Admin", 30, "admin@admin.com", "admin");

            admin.setRoles(new HashSet<>(Set.of(role)));
            userService.saveUser(admin);
        }

    }

}
