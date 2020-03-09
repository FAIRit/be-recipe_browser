package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class SpoonacularServiceApiCalls {
    private final static String SEARCH_URL = "https://api.spoonacular.com/recipes/search";
    private final static String SEARCH_BY_INGREDIENTS_URL = "https://api.spoonacular.com/recipes/findByIngredients";

    private final RestTemplate restTemplate;
    private final RecipeUrlCreator recipeUrlCreator;

    public ResponseEntity<RecipeResults> searchRecipe(String recipe) {
        log.info("Composed url: " + SEARCH_URL);
        ResponseEntity<RecipeResults> resp = restTemplate.exchange(
                recipeUrlCreator.createURLWithKey(SEARCH_URL + recipeSearch(recipe)),
                HttpMethod.GET,
                null,
                RecipeResults.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String recipeSearch(String recipe) {
        return "?query=" + recipe + "&number=5";
    }

    public ResponseEntity<RecipesWithDefinedIngredients> searchRecipeWithIngredients(Ingredients ingredients) {
        log.info("Composed url: " + SEARCH_BY_INGREDIENTS_URL);
        ResponseEntity<RecipesWithDefinedIngredients> resp = restTemplate.exchange(
                recipeUrlCreator.createURLWithKey(SEARCH_BY_INGREDIENTS_URL + searchRecipeWithIngredients(ingredients.compose())),
                HttpMethod.GET, null,
                RecipesWithDefinedIngredients.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String searchRecipeWithIngredients(String ingredients) {
        return "?ingredients=" + ingredients + "&number=5";
    }
}

