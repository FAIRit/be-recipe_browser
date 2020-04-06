package com.fairit.recipe_browser.model.randomSearchRecipe;


import com.fairit.recipe_browser.model.recipeInformation.Metric;
import com.fairit.recipe_browser.model.recipeInformation.Us;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measures {

    private Us us;
    private Metric metric;

}
