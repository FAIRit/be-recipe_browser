package com.fairit.recipe_browser.service;

import com.fairit.recipe_browser.model.FavouriteRecipe;
import com.fairit.recipe_browser.model.Recipe;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import com.fairit.recipe_browser.repository.RandomRecipeRepository;
import com.fairit.recipe_browser.repository.RecipeRepository;
import com.fairit.recipe_browser.repository.RecipesWithDefinedIngredientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavouriteService {
    private final RecipeRepository recipeRepository;
    private final RecipesWithDefinedIngredientsRepository recipesWithDefinedIngredientsRepository;
    private final RandomRecipeRepository randomRecipeRepository;

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void save(RecipesWithDefinedIngredients recipe) {
        recipesWithDefinedIngredientsRepository.save(recipe);
    }

    public void save(RecipeRandom recipe) {
        randomRecipeRepository.save(recipe);
    }

    public List<FavouriteRecipe> list() {
        List<FavouriteRecipe> recipes = new ArrayList<>();
        randomRecipeRepository.findAll().forEach(recipes::add);
        return recipes;


        //GET https://api.spoonacular.com/recipes/{id}/information
    }


}
