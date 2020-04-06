package com.fairit.recipe_browser.repository;

import com.fairit.recipe_browser.model.recipeInformation.RecipeInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInformationRepository extends JpaRepository <RecipeInformation, Long> {
}
