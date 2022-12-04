package learn.project.recipewebapp.model;

import lombok.Data;

@Data
public class Ingredient {

    private Long ingredientID;
    //Название в формате строки;
    private String title;
    //Количество ингредиентов в формате целого положительного числа;
    private int quantity;
    //Единица измерения в формате строки.
    private String measureUnit;
    static Long counterID = 1L;


    public Ingredient(String title, int quantity, String measureUnit) {
        this.title = title;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        ingredientID = counterID;
        counterID++;
    }
}
