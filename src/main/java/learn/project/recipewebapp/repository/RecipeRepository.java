package learn.project.recipewebapp.repository;

import learn.project.recipewebapp.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RecipeRepository implements iRepository<Recipe> {
    private final Map<Long, Recipe> recipeStorage = new HashMap<>();

    @Override
    public void add(Long id, Recipe recipe) {
        if (!recipeStorage.containsKey(id) & recipe != null) {
            recipeStorage.put(id, recipe);
        } else {
            recipeStorage.put(id, new Recipe());
        }
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
