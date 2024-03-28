package ua.dragunovskiy.test_task.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.test_task.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
public class BookDao implements Dao<UUID, Book> {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<Book> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Book> query = session.createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void add(Book entity) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(entity);
    }

    @Override
    @Transactional
    public Book update(UUID id, Book bookForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Book updatedBook = session.get(Book.class, id);
        updatedBook.setId(bookForUpdate.getId());
        updatedBook.setTitle(bookForUpdate.getTitle());
        updatedBook.setAuthor(bookForUpdate.getAuthor());
        updatedBook.setIsbn(bookForUpdate.getIsbn());
        session.merge(updatedBook);
        return updatedBook;
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        Book deletedBook = session.get(Book.class, id);
        session.remove(deletedBook);
    }
}
