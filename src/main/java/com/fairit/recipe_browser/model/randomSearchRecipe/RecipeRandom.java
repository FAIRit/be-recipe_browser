package com.fairit.recipe_browser.model.randomSearchRecipe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRandom {

    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean veryHealthy;
    private boolean cheap;
    private boolean veryPopular;
    private boolean sustainable;
    private Double weightWatcherSmartPoints;
    private String gaps;
    private boolean lowFodmap;
    private String sourceUrl;
    private String spoonacularSourceUrl;
    private Integer aggregateLikes;
    private Integer spoonacularScore;
    private Integer healthScore;
    private String creditsText;
    private String license;
    private String sourceName;
    private Double pricePerServing;

    @ElementCollection
    @CollectionTable(name = "extendedIngredients")
    private List<ExtendedIngredient> extendedIngredients;

    private Long id;
    private String title;
    private Integer readyInMinutes;
    private Integer servings;
    private String image;
    private String imageType;
    private String summary;

    @ElementCollection
    @CollectionTable(name = "cuisines")
    private List<String> cuisines;

    @ElementCollection
    @CollectionTable(name = "dishTypes")
    private List<String> dishTypes;

    @ElementCollection
    @CollectionTable(name = "diets")
    private List<String> diets;

    @ElementCollection
    @CollectionTable(name = "occasions")
    private List<String> occasions;

    @ElementCollection
    @CollectionTable(name = "WinePairing")
    private List<WinePairing> winePairing;

    private String instructions;

    @ElementCollection
    @CollectionTable(name = "analyzedInstructions")
    private List<AnalyzedInstructions> analyzedInstructions;

    public Integer originalId;
}
