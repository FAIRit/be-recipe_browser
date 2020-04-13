package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.model.AppUser;
import com.fairit.recipe_browser.service.FavoriteRecipesService;
import com.fairit.recipe_browser.service.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final FavoriteRecipesService favoriteRecipesService;

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

    @GetMapping("/addfavorite")
    public String addfavorite(@RequestParam(name = "recipeId") Long recipeId,
                              @RequestParam(name = "title") String title) {
        favoriteRecipesService.save(title, recipeId);
        return "redirect:/user/favorite-list";
    }

    @GetMapping("/favorite-list")
    public String getUserList(Principal principal, Model model) {
        String username = principal.getName();
        if (username == null) {
            return "redirect:/login";
        }
        Optional<AppUser> appUserOptional = userService.findUserByUsername(username);
        if (appUserOptional.isPresent()) {
            AppUser appUser = appUserOptional.get();
            appUser.setRecipes(favoriteRecipesService.list());
        }
        model.addAttribute("userName", username);
        model.addAttribute("favoriteList", favoriteRecipesService.list());
        return "favorite-list";
    }
}
