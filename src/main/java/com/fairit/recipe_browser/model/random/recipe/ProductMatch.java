package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMatch {

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
