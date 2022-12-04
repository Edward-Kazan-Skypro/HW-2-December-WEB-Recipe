package learn.project.recipewebapp.repository;

import java.util.Map;

public interface CommonRepository <T>{

    //Save method
    void save(Long id, T t);

    //Find by id
    T findById(Long id);

    //Get all
    Map<Long, T> viewAll();
}
