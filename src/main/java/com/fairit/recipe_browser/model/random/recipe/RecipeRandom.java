package com.fairit.recipe_browser.model.random.recipe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecipeRandom {

    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean glutenFree;
    private Boolean dairyFree;
    private Boolean veryHealthy;
    private Boolean cheap;
    private Boolean veryPopular;
    private Boolean sustainable;
    private Double weightWatcherSmartPoints;
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
    private Double pricePerServing;

//    @ElementCollection
//    @CollectionTable(name = "extendedIngredients")
    @Transient
    private List<ExtendedIngredient> extendedIngredients;

    @Id
    private Long id;
    private String title;
    private Integer readyInMinutes;
    private Integer servings;
    private String image;
    private String imageType;
    private String summary;

    @Transient
    private List<String> cuisines;

    @Transient
    private List<String> dishTypes;

    @Transient
    private List<String> diets;

    @Transient
    private List<String> occasions;

//    @Transient
//    private List<WinePairing> winePairing;

    private String instructions;

    @Transient
    private List<AnalyzedInstructions> analyzedInstructions;

    public Long originalId;
}
