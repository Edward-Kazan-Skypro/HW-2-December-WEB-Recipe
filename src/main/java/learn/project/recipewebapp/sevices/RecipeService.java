package learn.project.recipewebapp.sevices;

import learn.project.recipewebapp.model.Recipe;
import learn.project.recipewebapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe findRecipeById(Long recipeID) {
        Recipe recipe = recipeRepository.findById(recipeID);
        if (recipe == null) {
            throw new IllegalArgumentException();
        }
        return recipe;
    }

    public Map<Long, Recipe> updateRecipe(Long recipeID, Recipe recipe) {
        return recipeRepository.update(recipeID, recipe);
    }

    public void deleteRecipe(Long recipeID) {
        recipeRepository.delete(recipeID);
    }

    public Map<Long, Recipe> viewAllRecipes() {
        return recipeRepository.viewAll();
    }

    public Map<Long, Recipe> addRecipe(Recipe recipe) {
        return recipeRepository.add(recipe);
    }
}
