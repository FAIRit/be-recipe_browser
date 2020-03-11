package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Step {

    private Integer number;
    private String step;
    private List<IngredientsForRandomRecipe> ingredients;
    private List<Equipment> equipment;
    private StepLength length;

}