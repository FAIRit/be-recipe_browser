package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasuresProperties {

    private Double amount;
    private String unitShort;
    private String unitLong;
}
