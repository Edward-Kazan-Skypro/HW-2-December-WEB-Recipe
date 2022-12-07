package learn.project.recipewebapp.sevices;

import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.repository.IngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IngredientsService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientsService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public Ingredient findIngredientById(Long ingredientId) {
        return ingredientsRepository.findById(ingredientId);
    }

    public Map<Long, Ingredient> addIngredient(Ingredient ingredient) {
        return ingredientsRepository.add(ingredient);
    }

    public Map<Long, Ingredient> updateIngredient(Long ingredientID, Ingredient ingredient) {
        return ingredientsRepository.update(ingredientID, ingredient);
    }

    public void deleteIngredient(Long ingredientID) {
        ingredientsRepository.delete(ingredientID);
    }

    public Map<Long, Ingredient> viewAllIngredients() {
        return ingredientsRepository.viewAll();
    }
}
