package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductMatch {

    @Id
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageUrl;
    private Double averageRating;
    private Integer ratingCount;
    private Float score;
    private String link;
}
