package com.jeevankumar.springbootmongodb.repo;

import com.jeevankumar.springbootmongodb.dto.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByCategory(String category);
}

