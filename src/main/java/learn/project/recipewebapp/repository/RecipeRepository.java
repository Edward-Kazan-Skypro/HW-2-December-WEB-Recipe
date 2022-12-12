package learn.project.recipewebapp.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.model.Recipe;
import learn.project.recipewebapp.services.RecipeFilesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RecipeRepository implements iRepository<Recipe> {

    static Long idCounter = 1L;
    private Map<Long, Recipe> recipeStorage = new HashMap<>();

    private final RecipeFilesService recipeFilesService;

    public RecipeRepository(RecipeFilesService recipeFilesService) {
        this.recipeFilesService = recipeFilesService;
    }

    private boolean checkInputObject(Recipe recipe) {
        return StringUtils.isNotBlank(recipe.getTitleRecipe()) &
                StringUtils.isNotEmpty(recipe.getTitleRecipe()) &
                recipe.getCookingTimeMinutes() > 0 &
                !recipe.getIngredientsList().isEmpty() &
                !recipe.getCookingInstruction().isEmpty();
    }

    private String jsonFromList(){
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(recipeStorage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    private Map<Long, Recipe> listFromFile(){
        try {
            String json = recipeFilesService.readRecipeFromJsonFile();
            if (StringUtils.isNotEmpty(json) || StringUtils.isNotBlank(json) ){
                recipeStorage = new ObjectMapper().readValue(json, new TypeReference<>(){});
                //Если загружаем список рецептов из json файла,
                //то пусть он сразу дублируется в txt файле
                // (м.б. пользователь не будет ничего изменять, а сразу сохранить рецепты как txt файл).
                recipeFilesService.cleanRecipeTxtFile();
                recipeFilesService.saveRecipesToTxtFile(txtFromList());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return recipeStorage;
    }

    public String txtFromList(){
        String result = "";
        String ingredients = "";
        String cookingSteps = "";
        if (recipeStorage.isEmpty()) {
            result = "Список рецептов пуст, пожалуйста добавьте рецепты";
        } else {
            for (Recipe r: recipeStorage.values()) {
                for (int i = 0; i < r.getIngredientsList().size(); i++) {
                    Ingredient bufferIngredient = r.getIngredientsList().get(i);
                    ingredients = ingredients + bufferIngredient.getTitle() + " — " +
                            bufferIngredient.getQuantity() + " " +
                            bufferIngredient.getMeasureUnit() + "." + "\n";
                }
                for (int i = 0; i < r.getCookingInstruction().size(); i++) {
                    cookingSteps = cookingSteps + r.getCookingInstruction().get(i) + "\n";
                }
                result = result + r.getTitleRecipe() + "\n" +
                        "Время приготовления: " + r.getCookingTimeMinutes() + " минут." + "\n" +
                        "Ингредиенты:" + "\n" + ingredients + "\n" +
                        "Инструкция приготовления:" + "\n" + cookingSteps + "\n";
                ingredients = "";
                cookingSteps = "";
            }
        }
        return result;
    }

    @Override
    public boolean add(Recipe recipe) {
        if (checkInputObject(recipe) & !recipeStorage.containsValue(recipe)) {
            idCounter = 1L;
            while (recipeStorage.containsKey(idCounter)){
                idCounter++;
            }
            recipeStorage.put(idCounter, recipe);
            idCounter++;
            recipeFilesService.saveRecipesToJsonFile(jsonFromList());
            recipeFilesService.saveRecipesToTxtFile(txtFromList());
            return true;
        }
        return false;
    }

    @Override
    public Recipe findById(Long id) {
        if (recipeStorage.containsKey(id)) {
            return recipeStorage.get(id);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Long id, Recipe recipe) {
        if (!recipeStorage.containsKey(id)) {
            throw new IllegalArgumentException("С таким id рецепт отсутствует");
        }
        if (recipe != null) {
            if (checkInputObject(recipe)) {
                recipeStorage.remove(id);
                recipeStorage.put(id, recipe);
                recipeFilesService.saveRecipesToJsonFile(jsonFromList());
                recipeFilesService.saveRecipesToTxtFile(txtFromList());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (recipeStorage.containsKey(id)) {
            recipeStorage.remove(id);
            recipeFilesService.saveRecipesToJsonFile(jsonFromList());
            recipeFilesService.saveRecipesToTxtFile(txtFromList());
            return true;
        }
        return false;
    }

    @Override
    public Map<Long, Recipe> viewAll() {
        recipeStorage = listFromFile();
        if (!recipeStorage.isEmpty()) {
            return recipeStorage;
        }
        return null;
    }

    @PostConstruct
    private void init(){
        recipeStorage = listFromFile();
    }
}