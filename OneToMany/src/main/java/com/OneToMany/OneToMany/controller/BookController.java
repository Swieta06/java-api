package com.OneToMany.OneToMany.controller;

import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.model.Book;
import com.OneToMany.OneToMany.repository.BookRepository;
import com.OneToMany.OneToMany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/insert")
    public ResponseEntity<BookDto>insert(@RequestBody BookDto bookDto){
    BookDto bookDtoInsert=this.bookService.insert(bookDto);
    return new ResponseEntity<>(bookDtoInsert, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Book>getAllBooks(){
        List<Book>getBooks=bookService.getAllBooks();
        return getBooks;
    }
    @GetMapping("/search")
    public ResponseEntity<List<BookDto>>allBook(){
        return ResponseEntity.ok(bookRepository.getBook());
    }


}
