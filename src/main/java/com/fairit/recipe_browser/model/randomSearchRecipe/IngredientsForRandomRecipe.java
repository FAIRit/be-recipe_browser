package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsForRandomRecipe {

    private Long id;
    private String name;
    private String image;

}