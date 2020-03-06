package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
