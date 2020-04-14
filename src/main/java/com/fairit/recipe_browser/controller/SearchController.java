package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.*;
import com.fairit.recipe_browser.model.random.recipe.RecipeRandom;
import com.fairit.recipe_browser.model.recipe.information.RecipeInformation;
import com.fairit.recipe_browser.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/recipes/")
@AllArgsConstructor
public class SearchController {
    private final SearchRecipesService searchRecipesService;
    private final SearchRecipesByIngredientsService searchRecipesByIngredientsService;
    private final RandomRecipeService randomRecipeService;
    private final RecipeInformationService recipeInformationService;

    @GetMapping(path = "/search/")
    public String searchRecipes(Model model,
                                @RequestParam(name = "q", required = false) String phrase) {
        if (phrase != null && !phrase.isEmpty()) {
            RecipeResults searchResult = searchRecipesService.searchByRecipe(phrase);
            model.addAttribute("q", phrase);
            model.addAttribute("recipes", searchResult);
        }
        return "recipe-list";
    }

    @GetMapping(path = "/findByIngredients/")
    public String findRecipeByIngredients(Model model,
                                          @RequestParam(name = "q", required = false) String phrase) {
        if (phrase != null && !phrase.isEmpty()) {
            Ingredients ingredients = new Ingredients(phrase);
            List<RecipesWithDefinedIngredients> searchResult = searchRecipesByIngredientsService.searchRecipe(ingredients);
            model.addAttribute("q", phrase);
            model.addAttribute("searchResults", searchResult);
            model.addAttribute("total", searchResult.size());
        }
        return "findByIngredients-list";
    }

    @GetMapping(path = "/random/")
    public String findRandomRecipe(Model model) {
        RecipeRandom random = randomRecipeService.searchRandomRecipe();
        model.addAttribute("recipe", random);
//        model.addAttribute("title", random.getTitle());
        model.addAttribute("instructions", random.getInstructions());
        return "random-recipe";
    }

    @GetMapping(path = "/details/{recipeId}")
    public String recipesInformation(Model model,
                                     @PathVariable Long recipeId) {
        RecipeInformation recipeInformation = recipeInformationService.recipeInformationById(recipeId);
        model.addAttribute("q", recipeId);
        model.addAttribute("recipe", recipeInformation);
        return "recipe-details";
    }
}