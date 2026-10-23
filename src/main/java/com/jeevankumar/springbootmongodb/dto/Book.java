package com.jeevankumar.springbootmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "books")
public class Book {
    @Id
    private String id;

    private String isbnNumber;
    private String category;
    private String bookName;
}
