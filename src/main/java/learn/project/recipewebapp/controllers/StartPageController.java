package learn.project.recipewebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StartPageController {

    @GetMapping("/")
    public String startPage(){
        String welcomeMessage = "Приветствую. " +
                "Для просмотра всех добавленных рецептов перейдите по ссылке " +
                "http://localhost:8080/recipes/all." +
                "Для добавления рецепта используйте ссылку " +
                "http://localhost:8080/recipes/create/рецепт " +
                "Для просмотра какого-то одного рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/viewByID/номер_рецепта, например .../recipes/viewByID/2. " +
                "Для апдейта рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/update/id_рецепта " +
                "Для удаления рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/delete/id_рецепта " +

                "Для просмотра всех добавленных ингредиентов перейдите по ссылке " +
                "http://localhost:8080/ingredients/all. " +
                "Для добавления ингредиента используйте ссылку " +
                "http://localhost:8080/ingredients/create/ " +
                "Для просмотра какого-то одного ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/viewByID/номер_ингредиента, например .../ingredients/viewByID/3. " +
                "Для апдейта ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/update/id_ингредиента " +
                "Для удаления ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/delete/id_ингредиента";
        return welcomeMessage;
    }
}