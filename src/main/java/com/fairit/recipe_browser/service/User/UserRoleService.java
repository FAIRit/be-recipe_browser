package com.fairit.recipe_browser.service.User;

import com.fairit.recipe_browser.model.UserRole;

import java.util.Set;

public interface UserRoleService {
    Set<UserRole> getDefaultUserRoles();
}
