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
@RequestMapping(path = "/search/")
@AllArgsConstructor
public class SearchController {
    private final SearchRecipes searchRecipes;

    @GetMapping(path = "/recipes")
    public String searchRecipes(Model model,
                               @RequestParam(name = "q", required = false) String phrase) {
        if (phrase != null && !phrase.isEmpty()) {
            RecipeResults searchResult = searchRecipes.searchByRecipe(phrase);
            model.addAttribute("q", phrase);
            model.addAttribute("recipes", searchResult);
        }
        return "recipe-list";
    }
}
