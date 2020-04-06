package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.*;
import com.fairit.recipe_browser.model.randomSearchRecipe.RecipeRandom;
import com.fairit.recipe_browser.model.recipeInformation.RecipeInformation;
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
    private final FavouriteService favouriteService;
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

    @GetMapping(path = "/details/{recipeId}")
    public String recipesInformation(Model model,
//                                     @RequestParam(name = "q", required = false) Long recipeId,
                                     @PathVariable Long recipeId) {
        if (recipeId != null ) {
            RecipeInformation recipeInformation = recipeInformationService.recipeInformationById(recipeId);
            model.addAttribute("q", recipeId);
            model.addAttribute("recipe", recipeInformation);
        }
        return "recipe-details";
    }



    @PostMapping("/addfavourite")
    public String addfavourite(Recipe recipe) {
        favouriteService.save(recipe);

        return "redirect:/user/favourite-list";
    }

}