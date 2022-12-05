package learn.project.recipewebapp.repository;

import java.util.Map;

public interface iRepository<T> {
    //Добавление
    Map<Long, T> add(Long id, T t);

    //Поиск по id
    T findById(Long id);

    //Обновление
    Map<Long, T> update(Long id, T t);

    //Удаление
    void delete(Long id);

    //Просмотр всего списка
    Map<Long, T> viewAll();
}
