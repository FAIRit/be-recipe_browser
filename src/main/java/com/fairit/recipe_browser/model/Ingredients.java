package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    public Ingredients(String input) {
        String[] ingreds = input.split(",");
        for (String s : ingreds) {
            ingred.add(s.trim().toLowerCase().replaceAll(" ", ""));
        }
    }

    private List<String> ingred = new ArrayList<>();

    public String compose() {
        return ingred.stream().collect(Collectors.joining(",+"));
    }
}
