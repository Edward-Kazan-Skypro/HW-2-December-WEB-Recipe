package learn.project.recipewebapp.sevices;

import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.repository.IngredientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class IngredientsService {
    //private Long generatedIngredientId = 1L;
    private final IngredientsRepository ingredientsRepository;

    public Ingredient getIngredientById(Long ingredientId) {
        Ingredient ingredient = ingredientsRepository.getIngredientById(ingredientId);
        if (ingredient == null) {
            throw new IllegalArgumentException();
        }
        return ingredient;
    }

    public Map<Long, Ingredient> getAllIngredients(){
        return ingredientsRepository.getAllIngredients();
    }

    public void addIngredient(Ingredient ingredient) {
        //ingredients.put(generatedIngredientId, ingredient);
    }

    public Ingredient createIngredient (String title, int weight, String measureUnit){
        //generatedIngredientId++;
        Ingredient ingredient = new Ingredient(title, weight, measureUnit);
        return ingredient;
    }



    //public Ingredient updateIngredient(Long ingredientId, Ingredient ingredient) {
    //    ingredients.put(ingredientId, ingredient);
    //    return ingredient;
    //}

    //public Ingredient deleteIngredient(Long ingredientId) {
    //    return ingredients.remove(ingredientId);
    //}
}
