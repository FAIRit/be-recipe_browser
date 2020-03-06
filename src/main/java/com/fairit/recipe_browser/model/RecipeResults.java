package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResults {

    private List<Recipe> recipes;
    private String baseUri;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
    private Integer processingTimeMs;
    private Long expires;
    private Integer isStale;

}
