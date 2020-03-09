package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void registerUser (String username, String password, String passwordConfirm);
    List<AppUser> getAllUsers();
    Optional<AppUser> findUserByUsername(String username);
}
