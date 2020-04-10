package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.random.recipe.RecipeRandom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomRecipeRepository extends JpaRepository<RecipeRandom, Long> {
}
