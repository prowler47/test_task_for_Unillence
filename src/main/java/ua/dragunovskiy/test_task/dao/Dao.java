package ua.dragunovskiy.test_task.dao;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface Dao<T, E> {
    List<E> getAll();
    void add(E entity);
    E update(T id, E entityForUpdate);
    void delete(T id);
}
