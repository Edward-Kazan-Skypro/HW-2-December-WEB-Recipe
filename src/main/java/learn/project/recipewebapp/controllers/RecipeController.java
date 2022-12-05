package learn.project.recipewebapp.controllers;

import learn.project.recipewebapp.model.Recipe;
import learn.project.recipewebapp.sevices.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("viewByID/{recipeId}")
    public Recipe findRecipeById(@PathVariable String recipeId) {
        return recipeService.findRecipeById(Long.parseLong(recipeId));
    }

    @PostMapping()
    public Map<Long, Recipe> create(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe.getRecipeID(), recipe);
    }

    @PutMapping("updateByID/{recipeId}")
    public Map<Long, Recipe> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(Long.parseLong(recipeId), recipe);
    }

    @DeleteMapping("deleteByID/{recipeId}")
    public void delete(@PathVariable String recipeId) {
        recipeService.deleteRecipe(Long.parseLong(recipeId));
    }

    @GetMapping(value = "all")
    public Map<Long, Recipe> getAllRecipes() {
        return recipeService.viewAllRecipes();
    }

}
