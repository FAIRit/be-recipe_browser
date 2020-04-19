package com.fairit.recipe_browser.model.random.recipe;

import com.fairit.recipe_browser.model.recipe.information.Metric;
import com.fairit.recipe_browser.model.recipe.information.Us;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Measures {

    private Us us;
    private Metric metric;

}
