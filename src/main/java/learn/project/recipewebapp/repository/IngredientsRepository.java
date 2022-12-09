package learn.project.recipewebapp.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.services.IngredientsFilesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class IngredientsRepository implements iRepository<Ingredient> {

    static Long idCounter = 1L;
    private Map<Long, Ingredient> ingredientsStorage = new HashMap<>();

    private final IngredientsFilesService ingredientsFilesService;

    public IngredientsRepository(IngredientsFilesService ingredientsFilesService) {
        this.ingredientsFilesService = ingredientsFilesService;
    }

    private String jsonFromList() {
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(ingredientsStorage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    private Map<Long, Ingredient> listFromFile() {
        try {
            String json = ingredientsFilesService.readIngredientsFromFile();
            if (StringUtils.isNotEmpty(json) || StringUtils.isNotBlank(json)) {
                ingredientsStorage = new ObjectMapper().readValue(json, new TypeReference<>() {
                });
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ingredientsStorage;
    }

    private boolean checkInputObject(Ingredient ingredient) {
        return !StringUtils.isBlank(ingredient.getTitle()) &
                !StringUtils.isEmpty(ingredient.getTitle()) &
                ingredient.getQuantity() >= 0 &
                !StringUtils.isBlank(ingredient.getMeasureUnit()) &
                !StringUtils.isEmpty(ingredient.getMeasureUnit());
    }

    @Override
    public Map<Long, Ingredient> add(Ingredient ingredient) {
        if (checkInputObject(ingredient) & !ingredientsStorage.containsValue(ingredient)) {
            idCounter = 1L;
            while (ingredientsStorage.containsKey(idCounter)) {
                idCounter++;
            }
            ingredientsStorage.put(idCounter, ingredient);
            idCounter++;
            ingredientsFilesService.saveIngredientsToFile(jsonFromList());
            return ingredientsStorage;
        }
        return null;
    }

    @Override
    public Ingredient findById(Long id) {
        if (ingredientsStorage.containsKey(id)) {
            return ingredientsStorage.get(id);
        } else {
            throw new IllegalArgumentException("Ингредиент с id " + id + " отсутствует!");
        }
    }

    @Override
    public Map<Long, Ingredient> update(Long id, Ingredient ingredient) {
        if (!ingredientsStorage.containsKey(id)) {
            throw new IllegalArgumentException("С таким id ингредиент отсутствует");
        }
        if (ingredient != null) {
            if (checkInputObject(ingredient)) {
                ingredientsStorage.remove(id);
                ingredientsStorage.put(id, ingredient);
                ingredientsFilesService.saveIngredientsToFile(jsonFromList());
                return ingredientsStorage;
            }
        } else {
            throw new IllegalArgumentException("Поля ингредиента для обновления не заполнены");
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (ingredientsStorage.containsKey(id)) {
            ingredientsStorage.remove(id);
            ingredientsFilesService.saveIngredientsToFile(jsonFromList());
        } else {
            throw new IllegalArgumentException("С таким id ингредиент отсутствует");
        }
    }

    @Override
    public Map<Long, Ingredient> viewAll() {
        ingredientsStorage = listFromFile();
        if (ingredientsStorage != null && !ingredientsStorage.isEmpty()) {
            return ingredientsStorage;
        }
        return null;
    }

    @PostConstruct
    private void init() {
        ingredientsStorage = listFromFile();
    }
}