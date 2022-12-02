package learn.project.recipewebapp.controllers;

import learn.project.recipewebapp.model.Ingredient;
import learn.project.recipewebapp.sevices.IngredientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController()
@AllArgsConstructor
public class IngredientController {

    private final IngredientsService ingredientsService;

    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient getIngredient(@PathVariable Long ingredientId) {
        return ingredientsService.getIngredientById(ingredientId);
    }

    @GetMapping("/ingredients/all")
    public Map<Long, Ingredient> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }


    @PostMapping("/add")
    public void addIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient ingredient){
        ingredientsService.addIngredient(ingredient);
    }



    //@PostMapping
    //public ResponseEntity createIngredient(@RequestParam String title, @RequestParam int weight, @RequestParam String measureUnit) {
       // Ingredient createdIngredient = ingredientsService.createIngredient(title, weight, measureUnit);
       // return ResponseEntity.ok(createdIngredient);
    //}

    //@ResponseBody
    //@GetMapping("/ingredients/{id}")
    //public ResponseEntity getIngredient(@PathVariable Long ingredientId) {
    //    Ingredient ingredient = ingredientsService.getIngredientById(ingredientId);
    //    if(ingredient == null) {
    //        return ResponseEntity.notFound().build();
    //    }
    //    return ResponseEntity.ok(ingredient);
    //}






    //@PutMapping()
    //public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient) {
        //Ingredient updatedIngredient = ingredientsService.updateIngredient(ingredient.getId(), ingredient);
        //return ResponseEntity.ok(updatedIngredient);
   //}
}
