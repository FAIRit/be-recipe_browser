package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.recipeInformation.RecipeInformation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeInformationService {

    private final SpoonacularServiceApiCalls apiCalls;

    public RecipeInformation recipeInformationById(Long id) {
        ResponseEntity<RecipeInformation> recipeInformation = apiCalls.searchRecipeInformation(id);
        return recipeInformation.getBody();
    }
}
