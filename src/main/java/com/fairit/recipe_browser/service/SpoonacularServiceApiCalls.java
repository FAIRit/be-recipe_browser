package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.configuration.HttpConfiguration;
import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.Recipe;
import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SpoonacularServiceApiCalls {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpConfiguration httpConfig;

    public ResponseEntity<RecipeResults> searchRecipe(String recipe) {
        String composedUrl = "https://api.spoonacular.com/recipes/search";
        log.info("Composed url: " + composedUrl);
        ResponseEntity<RecipeResults> resp = restTemplate.exchange(composedUrl + recipeSearch(recipe), HttpMethod.GET, httpConfig.getHttpEntity(), RecipeResults.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String recipeSearch(String recipe) {
        return "?query=" + recipe + "&number=5&apiKey=" + "17cc8ec769ef40cea70ed0456d3d851b";
    }

    public ResponseEntity<RecipesWithDefinedIngredients> searchRecipeWithIngredients (Ingredients ingredients){
        String composedUrl = "https://api.spoonacular.com/recipes/findByIngredients";
        log.info("Composed url: " + composedUrl);
        ResponseEntity<RecipesWithDefinedIngredients> resp = restTemplate.exchange(composedUrl + searchRecipeWithIngredients(ingredients), HttpMethod.GET, httpConfig.getHttpEntity(), RecipesWithDefinedIngredients.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String searchRecipeWithIngredients (String  ingredients){
        return "?ingredients=" + ingredients + "&number=5&apiKey=" + "17cc8ec769ef40cea70ed0456d3d851b";
    }
}

