package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return repository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setPublishedYear(updatedBook.getPublishedYear());
            return repository.save(book);
        }).orElse(null);
    }

    public boolean deleteBook(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> searchBooks(String title, String author, String genre, Integer year) {
        return repository.search(title, author, genre, year);
    }

    public Optional<Book> partialUpdate(Long id, Map<String, Object> updates) {
        return repository.findById(id).map(book -> {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "title" -> book.setTitle((String) value);
                    case "author" -> book.setAuthor((String) value);
                    case "genre" -> book.setGenre((String) value);
                    case "publishedYear" -> book.setPublishedYear((Integer) value);
                }
            });
            return repository.save(book);
        });
    }
}
