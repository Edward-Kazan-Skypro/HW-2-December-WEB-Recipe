package learn.project.recipewebapp.controllers;

import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.sevices.IngredientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController()
public class IngredientController {

    private final IngredientsService ingredientsService;

    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient findIngredientById(@PathVariable String ingredientId) {
        return ingredientsService.findIngredientById(Long.parseLong(ingredientId));
    }

    @GetMapping(value = "/ingredients/all")
    public Map<Long, Ingredient> viewAllIngredients() {
        return ingredientsService.viewAllIngredients();
    }

    @GetMapping(value="/ingredients/add/{string_title}/{int_quantity}/{string_measureUnit}")
    public void addIngredient(@PathVariable("string_title") String title,
                       @PathVariable("int_quantity") int quantity,
                      @PathVariable("string_measureUnit") String measureUnit)
    {
     ingredientsService.addIngredient(new Ingredient(title, quantity, measureUnit).getIngredientID(), new Ingredient(title, quantity, measureUnit));
    }
}
