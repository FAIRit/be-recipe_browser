package com.fairit.recipe_browser.model.recipe.information;

import com.fairit.recipe_browser.model.random.recipe.AnalyzedInstructions;
import com.fairit.recipe_browser.model.random.recipe.ExtendedIngredient;
import com.fairit.recipe_browser.model.random.recipe.WinePairing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeInformation {

    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean glutenFree;
    private Boolean dairyFree;
    private Boolean veryHealthy;
    private Boolean cheap;
    private Boolean veryPopular;
    private Boolean sustainable;
    private Integer weightWatcherSmartPoints;
    private String gaps;
    private Boolean lowFodmap;
    private String sourceUrl;
    private String spoonacularSourceUrl;
    private Integer aggregateLikes;
    private Integer spoonacularScore;
    private Integer healthScore;
    private String creditsText;
    private String license;
    private String sourceName;
    private List<ExtendedIngredient> extendedIngredients;
    private Long id;
    private String title;
    private Integer readyInMinutes;
    private Integer servings;
    private String image;
    private String imageType;
    private Nutrition nutrition;
    private String summary;
    private List<String> cuisines;
    private List<String> dishTypes;
    private List<String> diets;
    private List<String> occasions;
    private WinePairing winePairing;
    private String instructions;
    private List<AnalyzedInstructions> analyzedInstructions;
    private Long originalId;
}
