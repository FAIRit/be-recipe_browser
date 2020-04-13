package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.FavouriteRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRecipeRepository extends JpaRepository<FavouriteRecipe, Long> {
}
