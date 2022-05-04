package com.OneToMany.OneToMany.controller;

import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<BookDto>insert(@RequestBody BookDto bookDto){
    BookDto bookDtoInsert=this.bookService.insert(bookDto);
    return new ResponseEntity<>(bookDtoInsert, HttpStatus.CREATED);
    }

}
