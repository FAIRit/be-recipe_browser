package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.FavoriteRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRecipesRepository extends JpaRepository<FavoriteRecipes, Long> {
}
