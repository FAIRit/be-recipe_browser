package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchRecipesByIngredientsService {

    private final SpoonacularServiceApiCalls apiCalls;

    public RecipesWithDefinedIngredients searchRecipe(Ingredients ingredients) {
        ResponseEntity<RecipesWithDefinedIngredients> searchRecipesWithDefinedIngredients = apiCalls.searchRecipeWithIngredients(ingredients);

        return searchRecipesWithDefinedIngredients.getBody();
    }
}
