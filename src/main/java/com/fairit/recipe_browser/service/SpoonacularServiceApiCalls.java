package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.configuration.HttpConfiguration;
import com.fairit.recipe_browser.model.RecipeResults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${api.spoonacular.com}")
    private String spoonacularApiAddress;

    @Autowired
    public SpoonacularServiceApiCalls(final RestTemplate restTemplate, final HttpConfiguration httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

///////


    public ResponseEntity<RecipeResults> searchRecipe(String recipe) {
        String composedUrl = "https://api.spoonacular.com/recipes/search";
        log.info("Composed url: " + composedUrl);
        ResponseEntity<RecipeResults> resp = restTemplate.exchange(composedUrl + recipeSearch(recipe), HttpMethod.GET, httpConfig.getHttpEntity(), RecipeResults.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String recipeSearch(String recipe) {
        return "?query=" + recipe + "&number=5";
    }
}


