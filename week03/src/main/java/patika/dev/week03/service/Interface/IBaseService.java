package patika.dev.week03.service.Interface;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IBaseService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T uptadeOnDatabese(T object );

}
