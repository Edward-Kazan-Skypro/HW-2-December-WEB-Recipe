package learn.project.recipewebapp.repository;

import java.util.Map;

public interface iRepository<T> {
    //Добавление
    boolean add(T t);

    //Поиск по id
    T findById(Long id);

    //Обновление
    boolean update(Long id, T t);

    //Удаление
    boolean delete(Long id);

    //Просмотр всего списка
    Map<Long, T> viewAll();
}