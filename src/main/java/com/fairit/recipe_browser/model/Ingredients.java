package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
        StringBuilder builder = new StringBuilder();
        for (String s : ingred) {
            builder.append(s).append(",+");
        }
        return builder.toString().substring(0, builder.length() - 2);
    }
}
