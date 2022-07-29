package repository;

import java.util.List;

public interface ICrudRepository<T> {
    List<T> findAll();
    T findById(int id);
    void saveDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(int id);
    void uptadeOnDatabese(T object , int id);
}
