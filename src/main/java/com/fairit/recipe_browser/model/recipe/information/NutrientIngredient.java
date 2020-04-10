package com.fairit.recipe_browser.model.recipe.information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutrientIngredient {

    private String name;
    private Double amount;
    private String unit;
}
