package learn.project.recipewebapp.services;

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
        return recipeRepository.findById(recipeID);
    }

    public boolean updateRecipe(Long recipeID, Recipe recipe) {
        return recipeRepository.update(recipeID, recipe);
    }

    public boolean deleteRecipe(Long recipeID) {
        return recipeRepository.delete(recipeID);
    }

    public Map<Long, Recipe> viewAllRecipes() {
        return recipeRepository.viewAll();
    }

    public boolean addRecipe(Recipe recipe) {
        return recipeRepository.add(recipe);
    }
}