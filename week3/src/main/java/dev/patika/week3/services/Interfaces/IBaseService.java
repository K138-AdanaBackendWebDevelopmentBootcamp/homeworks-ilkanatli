package dev.patika.week3.services.Interfaces;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T update(T object,int id);
}