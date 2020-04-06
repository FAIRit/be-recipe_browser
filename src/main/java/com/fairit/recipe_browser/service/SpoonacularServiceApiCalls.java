package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import com.fairit.recipe_browser.model.recipeInformation.RecipeInformation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SpoonacularServiceApiCalls {
    private final static String SEARCH_URL = "https://api.spoonacular.com/recipes/search";
    private final static String SEARCH_BY_INGREDIENTS_URL = "https://api.spoonacular.com/recipes/findByIngredients";
  //  private final static String RANDOM_RECIPE_URL = "https://api.spoonacular.com/recipes/random";
    private final static String RANDOM_RECIPE_URL = "https://api.spoonacular.com/recipes/random?number=1";
    private final static String RECIPE_INFORMATION_URL = "https://api.spoonacular.com/recipes";

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

    public ResponseEntity<List<RecipesWithDefinedIngredients>> searchRecipeWithIngredients(Ingredients ingredients) {
        log.info("Composed url: " + SEARCH_BY_INGREDIENTS_URL);
        ResponseEntity<List<RecipesWithDefinedIngredients>> resp = restTemplate.exchange(
                recipeUrlCreator.createURLWithKey(SEARCH_BY_INGREDIENTS_URL + searchRecipeWithIngredients(ingredients.compose())),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        log.info(": " + resp.getBody());
        return resp;
    }

    private String searchRecipeWithIngredients(String ingredients) {
        return "?ingredients=" + ingredients + "&number=10";
    }

//    public ResponseEntity<RecipeRandom> randomRecipe(String tags) {
//        log.info("Composed url: " + RANDOM_RECIPE_URL);
//        ResponseEntity<RecipeRandom> resp = restTemplate.exchange(
//                recipeUrlCreator.createURLWithKey(RANDOM_RECIPE_URL + searchRecipeRandom(tags)),
//                HttpMethod.GET,
//                null,
//                RecipeRandom.class);
//        log.info(": " + resp.getBody());
//        return resp;
//    }
//
//    private String searchRecipeRandom(String tag) {
//        return "?number=1&tags=" + tag;
//    }

    public ResponseEntity<RecipeRandom> randomRecipe() {
        log.info("Composed url: " + RANDOM_RECIPE_URL);
        ResponseEntity<RecipeRandom> resp = restTemplate.exchange(
                recipeUrlCreator.createURLWithKey(RANDOM_RECIPE_URL),
                HttpMethod.GET,
                null,
                RecipeRandom.class);
        log.info(": " + resp.getBody());
        return resp;
    }

    public ResponseEntity<RecipeInformation> searchRecipeInformation(Long id) {
        log.info("Composed url: " + RECIPE_INFORMATION_URL);
        ResponseEntity<RecipeInformation> resp = restTemplate.exchange(
                recipeUrlCreator.createURLWithKey(SEARCH_URL + recipeInformation(id)),
                HttpMethod.GET,
                null,
                RecipeInformation.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String recipeInformation(Long id) {
        return "/" + id + "/information?includeNutrition=false";
    }


}

