package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredients {

    private Long id;
    private Double amount;
    private String unit;
    private String unitLong;
    private String unitShort;
    private String aisle;
    private String name;
    private String extendedName;
    private String original;
    private String originalString;
    private String originalName;
    private List<String> metaInformation;
    private List<String> meta;
    private String image;
}
