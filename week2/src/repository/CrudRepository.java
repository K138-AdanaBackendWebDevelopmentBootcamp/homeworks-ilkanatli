package repository;

import java.util.List;

public interface CrudRepository<T> {

    List<T> listAll();
    T findById(int id);
    void saveToDatabase(T t);
    void updateOnDatabase(T t, int id);
    void deleteFromDatabase(T t);
    void deleteFromDatabase(int id);

}
