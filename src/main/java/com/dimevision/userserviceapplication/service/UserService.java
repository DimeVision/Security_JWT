package com.dimevision.userserviceapplication.service;

import com.dimevision.userserviceapplication.domain.Role;
import com.dimevision.userserviceapplication.domain.User;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);
    List<User> getUsers();
}
