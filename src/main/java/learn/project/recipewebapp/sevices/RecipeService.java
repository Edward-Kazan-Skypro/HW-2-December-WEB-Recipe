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

    public Map<Long, Recipe> viewAllRecipes(){
        return recipeRepository.viewAll();
    }

    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe.getRecipeID(), recipe);
    }
}
