package com.jeevankumar.springbootmongodb.controller;

import com.jeevankumar.springbootmongodb.dto.Book;
import com.jeevankumar.springbootmongodb.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getAllBooks());
    }

    @GetMapping("/category")
    public ResponseEntity<List<Book>> getAllBookByCategory(@RequestParam String category) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getAllBookByCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id) {
        if (bookService.deleteBookById(id)) {
            return ResponseEntity.ok("Book deleted successfully:  " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book not found with id: " + id);
    }
}
