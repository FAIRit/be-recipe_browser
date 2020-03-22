package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class FavouriteRecipe {

    @Id
    private Long id;
    private String title;

}
