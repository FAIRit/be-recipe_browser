package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsByName (String name);

    UserRole findByName (String role);
}
