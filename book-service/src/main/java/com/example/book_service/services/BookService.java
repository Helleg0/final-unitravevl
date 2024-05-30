package com.example.book_service.services;

import com.example.book_service.model.dtos.BookRequest;
import com.example.book_service.model.dtos.BookResponse;
import com.example.book_service.model.entities.Book;
import com.example.book_service.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    public void addBook(BookRequest bookRequest){
        var book = Book.builder()
                .idBook(bookRequest.getIdBook())
                .price(bookRequest.getPrice())
                .date(bookRequest.getDate()).build();

        bookRepository.save(book);
        log.info("Book added: {}",book);
    }

    public List<BookResponse> getAllBooks(){
        var books = bookRepository.findAll();

        return books.stream().map(this::maptoBookResponse).toList();
    }

    private BookResponse maptoBookResponse(Book book){
        return BookResponse.builder()
                .idBook(book.getIdBook())
                .idAccommodation(book.getIdAccommodation())
                .idDestiny(book.getIdDestiny())
                .idFly(book.getIdFly())
                .idUser(book.getIdUser())
                .price(book.getPrice())
                .date(book.getDate())
                .build();
    }

    public void updateBook(BookRequest bookRequest){
        Optional<Book> optionalBook = bookRepository.findById(bookRequest.getIdBook());

        if(optionalBook.isPresent()){
            Book book = optionalBook.get();

            book.setIdAccommodation(bookRequest.getIdAccommodation());
            book.setIdDestiny(bookRequest.getIdDestiny());
            book.setIdFly(bookRequest.getIdFly());
            book.setIdUser(bookRequest.getIdUser());
            book.setPrice(book.getPrice());
            book.setDate(book.getDate());

            bookRepository.save(book);

            log.info("Book Update: {}",book);
        }else{
            log.error("Book with ID {} not found",bookRequest.getIdBook());
        }
    }

    public void  deleteBook(Long bookID){
        Optional<Book> optionalBook = bookRepository.findById(bookID);

    }

    public void DateInUse(BookRequest bookRequest){
        Optional<Book> optionalBook = bookRepository.findById(bookRequest.getIdBook());
        if(optionalBook.get().getDate()!=bookRequest.getDate()){
            log.info("The destiny can be book");
        }else{
            log.error("The Date is already occupied");
        }
    }

}


