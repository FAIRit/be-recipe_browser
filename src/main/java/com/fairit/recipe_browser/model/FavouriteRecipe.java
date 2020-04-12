package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavouriteRecipe {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Long serviceId;

}
