package learn.project.recipewebapp.controllers;

import learn.project.recipewebapp.model.Recipe;
import learn.project.recipewebapp.sevices.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipe(@PathVariable String recipeId) {
        return recipeService.findRecipeById(Long.parseLong(recipeId));
    }

    @GetMapping(value = "/recipes/all")
    public Map<Long, Recipe> getAllRecipes() {
        return recipeService.viewAllRecipes();
    }

    @GetMapping(value="/recipes/add/{recipe_recipe}")
    public void addRecipe(@PathVariable("recipe_recipe") Recipe recipe) {
        recipeService.addRecipe(recipe);
    }
}
