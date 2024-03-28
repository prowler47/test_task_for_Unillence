package ua.dragunovskiy.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.test_task.entity.Book;
import ua.dragunovskiy.test_task.service.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable("id") UUID id, @RequestBody Book bookForUpdate) {
        return bookService.update(id, bookForUpdate);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookService.delete(id);
    }
}
