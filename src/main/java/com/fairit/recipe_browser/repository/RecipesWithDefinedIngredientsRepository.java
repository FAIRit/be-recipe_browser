package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.RecipesWithDefinedIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesWithDefinedIngredientsRepository extends JpaRepository<RecipesWithDefinedIngredients, Long> {
}
