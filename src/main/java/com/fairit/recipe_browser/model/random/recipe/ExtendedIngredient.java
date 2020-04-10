package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExtendedIngredient {

    @Id
    private Long id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private String original;
    private String originalString;
    private String originalName;
    private Double amount;
    private String unit;

    @ElementCollection
    @CollectionTable(name = "meta")
    private List<String> meta;

    @ElementCollection
    @CollectionTable(name = "metaInformation")
    private List<String> metaInformation;

    @Transient
    private Measures measures;

}