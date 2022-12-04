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
        Ingredient ingredient = ingredientsRepository.findById(ingredientId);
        if (ingredient == null) {
            throw new IllegalArgumentException();
        }
        return ingredient;
    }

    public Map<Long, Ingredient> viewAllIngredients(){
        return ingredientsRepository.viewAll();
    }

    public void addIngredient(Long id, Ingredient ingredient) {
        ingredientsRepository.save(id, ingredient);
    }
}
