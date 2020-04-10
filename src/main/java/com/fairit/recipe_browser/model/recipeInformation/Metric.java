package com.fairit.recipe_browser.model.recipeInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Metric {

    private Float amount;
    private String unitShort;
    private String unitLong;
}
