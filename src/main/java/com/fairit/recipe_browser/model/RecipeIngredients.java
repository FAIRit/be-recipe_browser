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
public class RecipeIngredients {
    @Id
    private Long id;

    private Double amount;
    private String unit;
    private String unitLong;
    private String unitShort;
    private String aisle;
    private String name;
    private String extendedName;
    private String original;
    private String originalString;
    private String originalName;

    @ElementCollection
    @CollectionTable(name = "metaInformations")
    private List<String> metaInformation;

    @ElementCollection
    @CollectionTable(name = "metas")
    private List<String> meta;

    private String image;
}
