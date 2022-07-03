package repository;

import java.util.List;

// CRUD --> Create, Read, Update, Delete
public interface CrudRepository<T> {

    List<T> findAll();
    T findById(int id);
    void saveToDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(int id);
    void updateOnDatabase(T object);
}
