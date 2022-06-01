package com.onetoone.service;

import com.onetoone.dto.BookChapterGroupResponse;
import com.onetoone.dto.BookChapterResponse;
import com.onetoone.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto insert(BookDto bookDto) throws Exception;

    public List<BookChapterResponse> getBookChapter();

    public List<BookChapterGroupResponse> getBookChapterGroup() throws Exception;

    public Integer getTotalBooks();
}
