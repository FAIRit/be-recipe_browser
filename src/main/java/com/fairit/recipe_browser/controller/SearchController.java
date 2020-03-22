package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.Ingredients;
import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import com.fairit.recipe_browser.service.RandomRecipeService;
import com.fairit.recipe_browser.service.SearchRecipesByIngredientsService;
import com.fairit.recipe_browser.service.SearchRecipesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            //    model.addAttribute("recipes", searchResult.get(1).getId());
            model.addAttribute("title", searchResult.get(1).getTitle());
            model.addAttribute("usedIngredients", searchResult.get(1).getUsedIngredients());
            model.addAttribute("total", searchResult.size());
            model.addAttribute("image", searchResult.get(1).getImage());
        }
        return "findByIngredients-list";
    }

//    @GetMapping(path = "/random/")
//    public String findRandomRecipe(Model model,
//                                   @RequestParam(name = "q", required = false) String phrase) {
//        if (phrase != null && !phrase.isEmpty()) {
//            RecipeRandom randomRecipe = randomRecipeService.searchRandomRecipe(phrase);
//            model.addAttribute("q", phrase);
//            model.addAttribute("recipe", randomRecipe);
//            model.addAttribute("dishType", randomRecipe.getDishTypes().listIterator().toString().intern());
//            model.addAttribute("dishTypes", randomRecipe.getDishTypes().size());
//            model.addAttribute("title", randomRecipe.getTitle());
//            model.addAttribute("instructions", randomRecipe.getInstructions());
//        }
//        return "random-recipe";
//    }

    @GetMapping(path = "/random/")
    public String findRandomRecipe(Model model) {
        RecipeRandom random = randomRecipeService.searchRandomRecipe();
        model.addAttribute("title", random.getTitle());
        model.addAttribute("description", random.getSummary());
        return "random-recipe";
    }

}