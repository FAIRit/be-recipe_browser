package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.FavouriteRecipe;
import com.fairit.recipe_browser.model.Recipe;
import com.fairit.recipe_browser.service.FavouriteRecipeService;
import com.fairit.recipe_browser.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavouriteRecipeService favouriteRecipeService;

    @GetMapping("/register")
    public String getRegisterForm() {
        return "user/userRegister";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam(name = "username") String username,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "password-confirm") String passwordConfirm) {
        userService.registerUser(username, password, passwordConfirm);

        return "redirect:/login";
    }

    @GetMapping("/addfavourite")
    public String addfavourite(@RequestParam(name = "recipeId") Long recipeId) {
        favouriteRecipeService.save(recipeId);
        return "redirect:/user/favourite-list";
    }

    @GetMapping("/favourite-list")
    public String getUserList(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("favouriteList", favouriteRecipeService);
        return "favourite-list";
    }



}
