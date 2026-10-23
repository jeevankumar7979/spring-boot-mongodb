package com.jeevankumar.springbootmongodb.service;

import com.jeevankumar.springbootmongodb.dto.Book;
import com.jeevankumar.springbootmongodb.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllBookByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean deleteBookById(String id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
