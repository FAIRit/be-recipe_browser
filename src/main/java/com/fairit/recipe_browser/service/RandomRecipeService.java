package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.random.recipe.RecipeRandom;
import com.fairit.recipe_browser.model.random.recipe.RecipeRandomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RandomRecipeService {

    private final SpoonacularServiceApiCalls apiCalls;

    public RecipeRandom searchRandomRecipe() {
        ResponseEntity<RecipeRandomResponse> searchRandomExample = apiCalls.randomRecipe();
        return searchRandomExample.getBody().getRecipes().get(0);
    }
}
