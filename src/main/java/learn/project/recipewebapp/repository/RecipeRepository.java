package learn.project.recipewebapp.repository;

import learn.project.recipewebapp.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RecipeRepository implements CommonRepository<Recipe> {
    private IngredientsRepository ingredientsRepository;

    public RecipeRepository(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    private final Map<Long, Recipe> recipeStorage = new HashMap<>();

    //Попробовал добавить рецепт, но при такой реализации приложение не запускается.
    //Можно попробовать изменить класс Recipe в части сохранения списка ингредиентов -
    //сейчас это список объектов класса Ingredient,
    //и для обращения к списку (или добавления в него) надо обращаться к хранилищу ингредиентов (IngredientsRepository),
    //но запуск приложения не удается.
    //Если сделать список ингредиентов просто как строки, а не готовые объекты класса Ingredient,
    //то это нарушение условия домашней работы и тогда вообще нет смысла в отдельном классе Ingredient.
    //Поэтому ни одного готового рецепта добавить не могу...
    //Да и странно как то оперировать (особенно вручную вводить в нужной последовательности) большими строками через адресную строку браузера...
   /* {
        recipeStorage.put(1L, new Recipe("Сырники из творога",
                30,
                new ArrayList<>(List.of(ingredientsRepository.findById(1L),
                        ingredientsRepository.findById(2L),
                        ingredientsRepository.findById(3L),
                        ingredientsRepository.findById(4L))),
                new LinkedList<>(List.of("1. Смешайте весь творог с яйцами, сахаром и тщательно всё перемешайте.",
                        "2. Всыпьте в творог муку и тщательно перемешайте.",
                        "3. Поставьте сковороду на средний огонь и налейте в нее подсолнечное масло.", "Слепите несколько небольших шариков из получившейся творожной массы и положите их на тарелку. Затем по очереди обкатывайте творожные шарики в муке и выкладывайте на сковороду.",
                        "4. Обжаривайте сырники 1–2 минуты до появления золотистой корочки. Затем переверните их на другую сторону и также обжарьте до золотистого состояния.",
                        "5. Повторяйте, пока творог не закончится."))));
    }*/

    @Override
    public void save(Long id, Recipe recipe) {
        recipeStorage.put(recipe.getRecipeID(), recipe);
    }

    @Override
    public Recipe findById(Long id) {
        return recipeStorage.get(id);
    }

    @Override
    public Map<Long, Recipe> viewAll() {
        return null;
    }
}
