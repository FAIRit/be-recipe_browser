package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.FavouriteRecipe;
import com.fairit.recipe_browser.repository.FavouriteRecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavouriteRecipeService {

    private final FavouriteRecipeRepository favouriteRecipeRepository;

    public void save(Long recipeId) {
        FavouriteRecipe recipe = new FavouriteRecipe(recipeId);
        favouriteRecipeRepository.save(recipe);
    }

    public List<FavouriteRecipe> list() {
        List<FavouriteRecipe> recipes = new ArrayList<>();
        favouriteRecipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
