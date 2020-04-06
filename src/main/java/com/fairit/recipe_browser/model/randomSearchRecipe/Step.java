package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Step {

    @Id
    private Integer number;
    private String step;

    @ElementCollection
    @CollectionTable(name = "ingredientsFRR")
    private List<IngredientsForRandomRecipe> ingredients;

    @ElementCollection
    @CollectionTable(name = "equipment")
    private List<Equipment> equipment;

    @Transient
    private StepLength length;

}