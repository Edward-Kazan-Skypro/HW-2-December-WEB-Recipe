package learn.project.recipewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    //Название в формате строки;
    private String titleRecipe;
    //Время приготовления в минутах в формате целого положительного числа;
    private int cookingTimeMinutes;
    //Ингредиенты в формате списка объектов;
    private ArrayList<Ingredient> ingredientsList;
    //Шаги приготовления в формате списка строк.
    private LinkedList<String> cookingInstruction;
}