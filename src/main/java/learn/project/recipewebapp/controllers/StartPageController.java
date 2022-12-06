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
                "Для просмотра какого-то одного рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/viewByID/номер_рецепта, например .../recipes/viewByID/2. " +
                "Для апдейта рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/updateByID/id_рецепта " +
                "Для удаления рецепта сформируйте ссылку " +
                "http://localhost:8080/recipes/deleteByID/id_рецепта " +

                "Для просмотра всех добавленных ингредиентов перейдите по ссылке " +
                "http://localhost:8080/ingredients/all. " +
                "Для просмотра какого-то одного ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/viewByID/номер_ингредиента, например .../ingredients/viewByID/3. " +
                "Для апдейта ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/updateByID/id_ингредиента " +
                "Для удаления ингредиента сформируйте ссылку " +
                "http://localhost:8080/ingredients/deleteByID/id_ингредиента";
        return welcomeMessage;
    }
}
