package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipment {

    @Id
    private Long id;
    private String name;
    private String image;
}
