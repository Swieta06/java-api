package com.OneToMany.OneToMany.service;

import com.OneToMany.OneToMany.dto.BookChapterResponse;
import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.model.Book;

import java.util.List;

public interface BookService {
    public BookDto insert(BookDto bookDto);

    List<Book> getAllBooks();

    public List<BookChapterResponse> getBookChapter();
}
