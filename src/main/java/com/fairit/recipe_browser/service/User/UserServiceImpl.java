package com.fairit.recipe_browser.service.User;

import com.fairit.recipe_browser.exception.PasswordDoNotMatchException;
import com.fairit.recipe_browser.model.AppUser;
import com.fairit.recipe_browser.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private AppUserRepository appUserRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private UserRoleService userRoleService;

    @Autowired
    public UserServiceImpl(AppUserRepository appUserRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           UserRoleService userRoleService) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    @Override
    public void registerUser(String username, String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            throw new PasswordDoNotMatchException("Password and Password Confirm do not match.");
        }
        if (password.length() <= 3) {
            throw new PasswordDoNotMatchException("Password must be at least 4 characters.");
        }
        AppUser appUser = new AppUser();
        appUser.setEmail(username);
        appUser.setPassword(passwordEncoder.encode(password));
        appUser.setRoles(userRoleService.getDefaultUserRoles());

        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findUserByUsername(String username) {
        return appUserRepository.findByEmail(username);
    }
}