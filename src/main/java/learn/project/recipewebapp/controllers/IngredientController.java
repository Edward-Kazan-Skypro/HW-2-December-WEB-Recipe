package learn.project.recipewebapp.controllers;

import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.sevices.IngredientsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController()
@RequestMapping("ingredients")
public class IngredientController {

    private final IngredientsService ingredientsService;

    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("viewByID/{ingredientId}")
    public Ingredient findIngredientById(@PathVariable String ingredientId) {
        return ingredientsService.findIngredientById(Long.parseLong(ingredientId));
    }

    @PostMapping()
    public Map<Long, Ingredient> create(@RequestBody Ingredient ingredient) {
        return ingredientsService.createIngredient(ingredient.getIngredientID(), ingredient);
    }

    @PutMapping("updateByID/{ingredientId}")
    public Map<Long, Ingredient> update(@PathVariable String ingredientId, @RequestBody Ingredient ingredient) {
        return ingredientsService.updateIngredient(Long.parseLong(ingredientId), ingredient);
    }

    @DeleteMapping("deleteByID/{ingredientId}")
    public void delete(@PathVariable String ingredientId) {
        ingredientsService.deleteIngredient(Long.parseLong(ingredientId));
    }

    @GetMapping(value = "all")
    public Map<Long, Ingredient> viewAllIngredients() {
        return ingredientsService.viewAllIngredients();
    }
}
