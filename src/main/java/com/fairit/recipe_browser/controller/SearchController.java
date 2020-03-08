package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.RecipeResults;
import com.fairit.recipe_browser.service.SearchRecipes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/recipes/")
@AllArgsConstructor
public class SearchController {
    private final SearchRecipes searchRecipes;

    @GetMapping(path = "/search/")
    public String searchRecipes(Model model,
                                @RequestParam(name = "q", required = false) String phrase) {
        if (phrase != null && !phrase.isEmpty()) {
            RecipeResults searchResult = searchRecipes.searchByRecipe(phrase);
            model.addAttribute("q", phrase);
            model.addAttribute("recipes", searchResult);
        }
        return "recipe-list";
    }

//    @GetMapping(path = "/findByIngredients/")
//    public String findRecipeByIngredients(Model model,
//                                          @RequestParam(name = "ingr1", required = false) String ingr1,
//                                          @RequestParam(name = "ingr2", required = false) String ingr1),
//        @RequestParam(name = "ingr1", required = false) String ingr1){
//        @RequestParam(name = "ingr1", required = false) String ingr1){
//            @RequestParam(name = "ingr1", required = false) String ingr1){
//
//                if (ingr1 != null && !ingr1.isEmpty()) {
//                    //    RecipeResults searchResult = searchRecipes.searchByRecipe(element);
//                    model.addAttribute("ingr1", ingr1);
//                    model.addAttribute("ingr2", ingr2);
//                    model.addAttribute("ingr3", ingr1);
//                    model.addAttribute("ingr4", ingr1);
//                    model.addAttribute("ingr5", ingr1);
//
//
//                    model.addAttribute("recipes", searchResult);
//                }
//                return "findByIngredients-list";
//            }
//        }
}