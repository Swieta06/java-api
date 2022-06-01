package com.onetoone.controller;

import com.onetoone.dto.BookChapterGroupResponse;
import com.onetoone.dto.BookChapterResponse;
import com.onetoone.dto.BookDto;
import com.onetoone.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody BookDto bookDto) throws Exception {
        try {
            BookDto bookDtoInserted = this.bookService.insert(bookDto);

            return new ResponseEntity<>(bookDtoInserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/getBookChapter")
    public ResponseEntity<BookChapterResponse> getBookChapter() {
        List<BookChapterResponse> bookChapterResponseList =  this.bookService.getBookChapter();

        return new ResponseEntity(bookChapterResponseList, HttpStatus.OK);
    }

    @GetMapping("/getBookChapterGroup")
    public ResponseEntity<?> getBookChapterGroup() throws Exception {
        try {
            List<BookChapterGroupResponse> bookChapterGroupResponseList =  this.bookService.getBookChapterGroup();

            return new ResponseEntity<>(bookChapterGroupResponseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/totalBooks")
    public ResponseEntity<Integer> getTotalBooks() {
        Integer totalBooks = this.bookService.getTotalBooks();

        return new ResponseEntity<>(totalBooks, HttpStatus.OK);
    }

}
