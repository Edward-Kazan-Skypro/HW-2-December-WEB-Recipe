package learn.project.recipewebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StartPageController {

    @GetMapping("/")
    public String startPage(){
        String welcomeMessage = "Приветствую. " +
                "Для просмотра всех добавленных рецептов перейдите по ссылке http://localhost:8080/recipes/all." +
                "Для просмотра какого-то одного рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/номер_рецепта, например .../recipes/2. " +
                "Для добавления рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/add/рецепт " +
                "Для просмотра всех добавленных ингредиентов перейдите по ссылке http://localhost:8080/ingredients/all. " +
                "Для просмотра какого-то одного ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/номер_ингредиента, например .../ingredients/3. " +
                "Для добавления ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/add/название ингредиента/количество/ед.измерения" +
                ", например: .../лимон/1/штука.";
        return welcomeMessage;
    }
}
