package learn.project.recipewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {

    //Название в формате строки;
    private String title;
    //Количество ингредиентов в формате целого положительного числа;
    private int weight;
    //Единица измерения в формате строки.
    private String measureUnit;
    //Дополнительное поле - id ингредиента
    //private long ingredientId;
}
