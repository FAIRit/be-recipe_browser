package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.AppUser;
import com.fairit.recipe_browser.model.FavoriteRecipes;
import com.fairit.recipe_browser.repository.AppUserRepository;
import com.fairit.recipe_browser.repository.FavoriteRecipesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoriteRecipesService {

    private final FavoriteRecipesRepository favoriteRecipesRepository;
    private final AppUserRepository appUserRepository;

    public void save(String title, Long recipeId, String username) {
        FavoriteRecipes recipe = new FavoriteRecipes(title, recipeId);
        favoriteRecipesRepository.save(recipe);
        Optional<AppUser> appUser = appUserRepository.findByEmail(username);
        if (appUser.isPresent()) {
            AppUser user = appUser.get();
            user.getRecipes().add(recipe);
            appUserRepository.save(user);
        }
    }

    public List<FavoriteRecipes> list(String username) {
        return appUserRepository.findByEmail(username)
                .map(AppUser::getRecipes)
                .orElseThrow(() -> new RuntimeException("User is not logged in"));
    }

    public void delete(Long recipeId, String username) {
        appUserRepository.findByEmail(username).ifPresent(user -> user.getRecipes().stream()
                .filter(recipes -> recipes.getId().longValue() == recipeId.longValue())
                .findFirst()
                .ifPresent(recipes -> {
                    user.getRecipes().remove(recipes);
                    appUserRepository.save(user);
                    favoriteRecipesRepository.delete(recipes);
                })
        );
    }
}
