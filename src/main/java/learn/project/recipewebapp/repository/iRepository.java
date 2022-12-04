package learn.project.recipewebapp.repository;

import java.util.Map;

public interface iRepository<T>{

    //Save method
    void add(Long id, T t);

    //Find by id
    T findById(Long id);

    //Get all
    Map<Long, T> viewAll();
}
