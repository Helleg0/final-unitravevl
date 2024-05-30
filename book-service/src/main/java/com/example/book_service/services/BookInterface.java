package com.example.book_service.services;


import com.example.book_service.model.dtos.BookRequest;
import com.example.book_service.model.entities.Book;

import java.util.List;

public interface BookInterface {
    public List<Book> getAllBooks();
    public Book addBook(Book accommodation);
    public Book updateBook(int id, Book book);
    public void DateInUse(BookRequest bookRequest);
}
