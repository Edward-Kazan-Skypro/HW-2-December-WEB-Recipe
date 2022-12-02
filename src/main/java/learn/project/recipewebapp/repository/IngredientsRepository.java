package learn.project.recipewebapp.repository;

import learn.project.recipewebapp.model.Ingredient;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class IngredientsRepository {

    private final Map<Long, Ingredient> ingredientsStorage = new HashMap<>(Map.of(
            1L, new Ingredient("Куриное яйцо", 2, "штуки"),
            2L, new Ingredient("Пшеничная мука", 6, "столовых ложек"),
            3L, new Ingredient("Сахар", 2, "столовые ложки")));

    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientsStorage.get(ingredientId);
    }

    public Map<Long, Ingredient> getAllIngredients() {
        return ingredientsStorage;
    }

}
