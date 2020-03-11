package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedIngredient {

    private Long id;
    private String aisle;
    private String image;
    private String consitency;
    private String name;
    private String original;
    private String originalString;
    private String originalName;
    private Double amount;
    private String unit;
    private List<String> meta;
    private List<String> metaInformation;
    private Measures measures;

}