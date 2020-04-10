package com.fairit.recipe_browser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipesWithDefinedIngredients {

    @Id
    private Long id;

    private String title;
    private String image;
    private String imageType;
    private Integer usedIngredientCount;
    private Integer missedIngredientCount;

    @ManyToMany
    private List<RecipeIngredients> missedIngredients;
    @ManyToMany
    private List<RecipeIngredients> usedIngredients;
    @ManyToMany
    private List<RecipeIngredients> unusedIngredients;

    private Integer likes;

}
