package com.proje.repository;

import java.util.List;

// CRUD --> Create, Read, Update, Delete
public interface CrudRepository<T> {

    List<T> findAll();

    T findById(Long id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    T update(T object);
}
