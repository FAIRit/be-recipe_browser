package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.FavoriteRecipes;
import com.fairit.recipe_browser.repository.FavoriteRecipesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteRecipesService {

    private final FavoriteRecipesRepository favoriteRecipesRepository;

    public void save(String title, Long recipeId) {
        FavoriteRecipes recipe = new FavoriteRecipes(title, recipeId);
        favoriteRecipesRepository.save(recipe);
    }

    public List<FavoriteRecipes> list() {
        List<FavoriteRecipes> recipes = new ArrayList<>();
        favoriteRecipesRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
