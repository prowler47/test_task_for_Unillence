package ua.dragunovskiy.test_task.service;

import java.util.List;

public interface AbstractService<T, E> {
    List<E> getAll();
    void add(E entity);

    E update(T id, E updatedEntity);
    void delete(T id);
}
