package com.fairit.recipe_browser.model.recipeInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NutrientIngredient {

    @Id
    private String name;
    private Double amount;
    private String unit;
}
