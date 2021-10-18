package com.dimevision.userserviceapplication.repository;

import com.dimevision.userserviceapplication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
