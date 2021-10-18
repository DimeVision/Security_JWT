package com.dimevision.userserviceapplication.repository;

import com.dimevision.userserviceapplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
