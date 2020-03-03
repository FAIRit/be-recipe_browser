package com.fairit.recipe_browser.configuration;

import com.fairit.recipe_browser.model.AppUser;
import com.fairit.recipe_browser.model.UserRole;
import com.fairit.recipe_browser.repository.AppUserRepository;
import com.fairit.recipe_browser.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        createRoleIfNotExist("ADMIN");
        createRoleIfNotExist("USER");

        createUserWithRoleIfNotExist("admin", "admin", "ADMIN", "USER");
        createUserWithRoleIfNotExist("user","user", "USER");
    }

    private void createUserWithRoleIfNotExist(String username, String password, String... roles){
        if(!appUserRepository.existsByEmail(username)){
            AppUser appUser = new AppUser();
            appUser.setEmail(username);
            appUser.setPassword(passwordEncoder.encode(password));

            appUser.setRoles((new HashSet<>(findRoles(roles))));

            appUserRepository.save(appUser);
        }
    }

    private List<UserRole> findRoles(String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();

        for (String role : roles){
            userRoles.add((userRoleRepository.findByName(role)));
        }
        return userRoles;
    }

    private void createRoleIfNotExist(String roleName) {
        if(!userRoleRepository.existsByName(roleName)){
            UserRole role = new UserRole();
            role.setName(roleName);

            userRoleRepository.save(role);
        }
    }
}
