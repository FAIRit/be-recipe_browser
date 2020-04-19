package com.fairit.recipe_browser.service.User;

import com.fairit.recipe_browser.model.UserRole;
import com.fairit.recipe_browser.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Value("USER")
    private String[] defaultRoles;

    @Override
    public Set<UserRole> getDefaultUserRoles() {

        Set<UserRole> roles = new HashSet<>();

        for (String role : defaultRoles) {
            roles.add((userRoleRepository.findByName(role)));
        }
        return roles;
    }
}
