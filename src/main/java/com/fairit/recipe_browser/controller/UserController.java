package com.fairit.recipe_browser.controller;

import com.fairit.recipe_browser.service.FavouriteService;
import com.fairit.recipe_browser.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private FavouriteService favouriteService;

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

    @GetMapping("/favourite-list")
    public String getUserList(Model model) {
        model.addAttribute("favouriteList", favouriteService.list());
        return "favourite-list";
    }
}
