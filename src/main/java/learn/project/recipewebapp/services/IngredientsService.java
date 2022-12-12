package learn.project.recipewebapp.services;

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

    public boolean addIngredient(Ingredient ingredient) {
        return ingredientsRepository.add(ingredient);
    }

    public boolean updateIngredient(Long ingredientID, Ingredient ingredient) {
        return ingredientsRepository.update(ingredientID, ingredient);
    }

    public boolean deleteIngredient(Long ingredientID) {
        return ingredientsRepository.delete(ingredientID);
    }

    public Map<Long, Ingredient> viewAllIngredients() {
        return ingredientsRepository.viewAll();
    }
}