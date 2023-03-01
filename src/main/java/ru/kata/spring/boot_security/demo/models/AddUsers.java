package ru.kata.spring.boot_security.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddUsers {

    private  final UserServiceImpl userService;


    @Autowired
    public AddUsers(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Transactional
    @Bean
    public void createUser() {

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");

        User user1 = new User("Ivan", "Petrov", 35, "ivan@mail.com", "ivan@mail.com",
                "ivan", new ArrayList<>(List.of(role1)));

        User user2 = new User("Oleg", "Ivanov", 36, "oleg@mail.com", "oleg@mail.com",
                "oleg", new ArrayList<>(List.of(role1, role2)));


        User user3 = new User("Pavel", "Borisov", 37, "pavel@mail.com", "pavel@mail.com",
                "pavel", new ArrayList<>(List.of(role2)));

        User user4 = new User("Boris", "Pavlov", 38, "boris@mail.com", "boris@mail.com",
                "boris", new ArrayList<>(List.of(role2)));


        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
    }
}
