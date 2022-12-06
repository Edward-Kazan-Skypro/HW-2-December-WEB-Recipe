package learn.project.recipewebapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class Recipe {
    private long recipeID;
    static Long counterID = 1L;

    //Название в формате строки;
    private String titleRecipe;
    //Время приготовления в минутах в формате целого положительного числа;
    private int cookingTimeMinutes;
    //Ингредиенты в формате списка объектов;
    private ArrayList<Ingredient> ingredientsList;
    //Шаги приготовления в формате списка строк.
    private LinkedList<String> cookingInstruction;

    public Recipe(String titleRecipe, int cookingTimeMinutes, ArrayList<Ingredient> ingredientsList, LinkedList<String> cookingInstruction) {
        this.titleRecipe = titleRecipe;
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.ingredientsList = ingredientsList;
        this.cookingInstruction = cookingInstruction;
        recipeID = counterID;
        counterID++;
    }

    public Recipe() {
        recipeID = counterID;
        counterID++;
    }
}