package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import com.fairit.recipe_browser.service.RandomRecipeService;
import com.fairit.recipe_browser.service.SearchRecipesService;
import com.fairit.recipe_browser.service.SearchRecipesByIngredientsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/recipes/")
@AllArgsConstructor
public class SearchController {
    private final SearchRecipesService searchRecipesService;
    private final SearchRecipesByIngredientsService searchRecipesByIngredientsService;
    private final RandomRecipeService randomRecipeService;

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
            model.addAttribute("recipes", searchResult);
        }
        return "findByIngredients-list";
    }

    @GetMapping(path = "/random/")
    public String findRandomRecipe(Model model) {


            RecipeRandom random = randomRecipeService.searchRandomRecipe();

            model.addAttribute("recipe", random);

        return "random_recipe";
    }

}