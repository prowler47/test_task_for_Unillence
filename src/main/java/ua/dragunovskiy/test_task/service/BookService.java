package ua.dragunovskiy.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.test_task.dao.Dao;
import ua.dragunovskiy.test_task.entity.Book;

import java.util.List;

@Service
public class BookService implements AbstractService<Integer, Book>{

    @Autowired
    private Dao<Integer, Book> bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void add(Book entity) {
        bookDao.add(entity);
    }

    @Override
    public Book update(Integer id, Book updatedEntity) {
        return bookDao.update(id, updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }
}
