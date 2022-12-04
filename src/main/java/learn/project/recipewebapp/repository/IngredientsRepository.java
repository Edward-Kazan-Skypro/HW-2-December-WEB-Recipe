package learn.project.recipewebapp.repository;

import learn.project.recipewebapp.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class IngredientsRepository implements iRepository<Ingredient> {

    private final Map<Long, Ingredient> ingredientsStorage = new HashMap<>();

    {
        ingredientsStorage.put(1L, new Ingredient("Куриное яйцо", 2, "штуки"));
        ingredientsStorage.put(2L, new Ingredient("Пшеничная мука", 6, "столовых ложек"));
        ingredientsStorage.put(3L, new Ingredient("Сахар", 2, "столовые ложки"));
        ingredientsStorage.put(4L, new Ingredient("Творог", 350, "г"));
        ingredientsStorage.put(5L, new Ingredient("Консервированная фасоль", 400, "г"));
        ingredientsStorage.put(6L, new Ingredient("Лимон", 1, "штука"));
        ingredientsStorage.put(7L, new Ingredient("Чеснок", 2, "зубчика"));
        ingredientsStorage.put(8L, new Ingredient("Оливковое масло", 50, "мл"));
        ingredientsStorage.put(9L, new Ingredient("Руккола", 50, "г"));
        ingredientsStorage.put(10L, new Ingredient("Творожный сыр", 200, "г"));
        ingredientsStorage.put(11L, new Ingredient("Красный лук", 50, "г"));
        ingredientsStorage.put(12L, new Ingredient("Красная чечевица", 150, "г"));
        ingredientsStorage.put(13L, new Ingredient("Репчатый лук", 1, "головка"));
        ingredientsStorage.put(14L, new Ingredient("Морковь", 1, "штука"));
        ingredientsStorage.put(15L, new Ingredient("Подсолнечное масло", 30, "мл"));
        ingredientsStorage.put(16L, new Ingredient("Сливочное масло", 15, "г"));
        ingredientsStorage.put(17L, new Ingredient("Пшеничная мука", 30, "г"));
        ingredientsStorage.put(18L, new Ingredient("Сливки 33%", 50, "мл"));
        ingredientsStorage.put(19L, new Ingredient("Специи", 0, "по вкусу"));
        ingredientsStorage.put(20L, new Ingredient("Лимон", 0, "½ штуки"));
        ingredientsStorage.put(21L, new Ingredient("Мята", 50, "по вкусу"));
        ingredientsStorage.put(22L, new Ingredient("Сливки 33%", 50, "мл"));

    }

    @Override
    public void add(Long id, Ingredient ingredient) {
        if (!ingredientsStorage.containsKey(id) & ingredient != null) {
            ingredientsStorage.put(id, ingredient);
        } else {
            ingredientsStorage.put(id, new Ingredient());

        }
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientsStorage.get(id);
    }

    @Override
    public Map<Long, Ingredient> viewAll() {
        if (!ingredientsStorage.isEmpty()) {
            return ingredientsStorage;
        }
        return null;
    }
}