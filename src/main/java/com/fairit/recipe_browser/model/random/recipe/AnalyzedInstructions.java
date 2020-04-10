package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnalyzedInstructions {

    @Id
    private String name;

    @Transient
    private List<Step> steps;
}
