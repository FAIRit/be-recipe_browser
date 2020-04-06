package com.fairit.recipe_browser.model.recipeInformation;

import lombok.Data;

import java.util.List;

@Data
public class Nutrition {

    private List<Nutrient> nutrients;
    private List<Ingredient> ingredients;
    private CaloricBreakdown caloricBreakdown;
    private WeightPerServing weightPerServing;
}
