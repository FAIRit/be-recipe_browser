package com.fairit.recipe_browser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    private Long id;

    private String title;
    private Integer readyInMinutes;
    private Integer servings;
    private String image;

    @ElementCollection
    @CollectionTable(name = "imageUrls")
    private List<String> imageUrls;


}
