package learn.project.recipewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    //Название в формате строки;
    private String title;
    //Количество ингредиентов в формате целого положительного числа;
    private int quantity;
    //Единица измерения в формате строки.
    private String measureUnit;
}
