package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RandomRecipeService {

    private final SpoonacularServiceApiCalls apiCalls;

    public RecipeRandom searchRandomRecipe() {
        ResponseEntity<RecipeRandom> searchRandomExample = apiCalls.randomRecipe();

        return searchRandomExample.getBody();
    }
}
