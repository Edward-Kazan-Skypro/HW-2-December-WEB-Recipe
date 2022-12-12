package learn.project.recipewebapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import learn.project.recipewebapp.model.Recipe;
import learn.project.recipewebapp.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("recipes")
@Tag(name = "Рецепты", description = "CRUD-операции для работы с рецептами")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("viewByID/{recipeId}")
    @Operation(summary = "Поиск рецепта по id",
            description = "Для поиска рецепта введите его id"
    )
    public ResponseEntity<String> findRecipeById(@PathVariable("recipeId") String recipeId) {
        Recipe recipe = recipeService.findRecipeById(Long.parseLong(recipeId));
        if (recipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Рецепт не найден. Ошибка 404 - Not Found");
        }
        try {
            return ResponseEntity.ok().body(new ObjectMapper().writeValueAsString(recipe));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping()
    @Operation(summary = "Добавление рецепта")
    public ResponseEntity<String> add(@RequestBody Recipe recipe) {
        if (recipeService.addRecipe(recipe)) {
            return ResponseEntity.status(HttpStatus.OK).body("Рецепт добавлен");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Рецепт не добавлен. Ошибка 400 - Bad Request");
    }

    @PutMapping("updateByID/{recipeId}")
    @Operation(summary = "Обновление сведений по рецепту",
            description = "Для добавления сведений введите его id и новый рецепт")
    public ResponseEntity<String> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        if (recipeService.updateRecipe(Long.parseLong(recipeId), recipe)) {
            return ResponseEntity.ok().body("Рецепт обновлен");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Рецепт не обновлен. Ошибка 400 - Bad Request");
    }

    @DeleteMapping("deleteByID/{recipeId}")
    @Operation(summary = "Удаление рецепта",
            description = "Для удаления рецепта введите его id")
    public ResponseEntity<String> delete(@PathVariable String recipeId) {
        if (recipeService.deleteRecipe(Long.parseLong(recipeId))) {
            return ResponseEntity.ok().body("Рецепт удален");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Рецепт не найден. Ошибка 404 - Not Found");
    }

    @GetMapping(value = "all")
    @Operation(summary = "Просмотр всех добавленных рецептов")
    public ResponseEntity<Map<Long, Recipe>> getAllRecipes() {
        return ResponseEntity.ok().body(recipeService.viewAllRecipes());
    }
}