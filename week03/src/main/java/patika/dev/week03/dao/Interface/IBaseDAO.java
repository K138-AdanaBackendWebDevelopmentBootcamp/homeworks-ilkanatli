package patika.dev.week03.dao.Interface;

import java.util.List;

public interface IBaseDAO<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T uptadeOnDatabese(T object );

}