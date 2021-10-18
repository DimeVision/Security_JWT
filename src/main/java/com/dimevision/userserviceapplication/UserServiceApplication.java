package com.dimevision.userserviceapplication;

import com.dimevision.userserviceapplication.domain.Role;
import com.dimevision.userserviceapplication.domain.User;
import com.dimevision.userserviceapplication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "doe", "1", new ArrayList<>()));
            userService.saveUser(new User(null, "Guthrie Govan", "govan", "1", new ArrayList<>()));
            userService.saveUser(new User(null, "Paul Gilbert", "gilbert", "1", new ArrayList<>()));
            userService.saveUser(new User(null, "Sergey Golovin", "golovin", "1", new ArrayList<>()));

            userService.addRoleToUser("doe", "ROLE_USER");
            userService.addRoleToUser("govan", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("govan", "ROLE_ADMIN");
            userService.addRoleToUser("gilbert", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("golovin", "ROLE_MANAGER");
            userService.addRoleToUser("golovin", "ROLE_ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
