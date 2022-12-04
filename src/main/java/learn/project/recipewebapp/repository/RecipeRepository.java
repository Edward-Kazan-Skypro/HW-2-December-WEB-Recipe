package learn.project.recipewebapp.repository;

import learn.project.recipewebapp.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RecipeRepository implements CommonRepository<Recipe> {
    private final Map<Long, Recipe> recipeStorage = new HashMap<>();

    @Override
    public void save(Long id, Recipe recipe) {
        recipeStorage.put(recipe.getRecipeID(), recipe);
    }

    @Override
    public Recipe findById(Long id) {
        return recipeStorage.get(id);
    }

    @Override
    public Map<Long, Recipe> viewAll() {
        return null;
    }
}
