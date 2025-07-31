package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(service.saveBook(book));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

  @GetMapping("/{id}")
    public ResponseEntity<Object> getBook(@PathVariable Long id) {
        return service.getBookById(id)
                .<ResponseEntity<Object>>map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.status(404).body("Book not found with ID: " + id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        Book updated = service.updateBook(id, book);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.status(404).body("Book not found");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return service.partialUpdate(id, updates)
                .<ResponseEntity<Object>>map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.status(404).body("Book not found for partial update"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return service.deleteBook(id)
                ? ResponseEntity.ok("Book deleted with ID: " + id)
                : ResponseEntity.status(404).body("Book not found");
    }

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year
    ) {
        return service.searchBooks(title, author, genre, year);
    }
}
