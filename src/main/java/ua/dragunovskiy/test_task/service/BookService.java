package ua.dragunovskiy.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.test_task.dao.Dao;
import ua.dragunovskiy.test_task.entity.Book;

import java.util.List;
import java.util.UUID;

@Service
public class BookService implements AbstractService<UUID, Book>{

    @Autowired
    private Dao<UUID, Book> bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void add(Book entity) {
        bookDao.add(entity);
    }

    @Override
    public Book update(UUID id, Book entityForUpdate) {
        return bookDao.update(id, entityForUpdate);
    }

    @Override
    public void delete(UUID id) {
        bookDao.delete(id);
    }
}
