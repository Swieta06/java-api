package com.onetoone.controller;

import com.onetoone.dto.BookDto;
import com.onetoone.dto.ChapterDto;
import com.onetoone.entity.Book;
import com.onetoone.entity.Chapter;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public BookDto getBookDto() {
        BookDto bookDto = new BookDto();
        bookDto.setAuthor("author");
        bookDto.setTitle("title");
        bookDto.setYear("2022");
        bookDto.setIsDeleted(false);

        ChapterDto chapterDto = new ChapterDto();
        chapterDto.setId(1L);
        chapterDto.setContent("content");
        chapterDto.setName("name");
        chapterDto.setIsDeleted(false);
        chapterDto.setBook(bookDto);
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        chapterDtoList.add(chapterDto);
        bookDto.setChapterDtoList(chapterDtoList);

        return bookDto;
    }

    public BookDto getBookSavedDto() {
        BookDto bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setAuthor("author");
        bookDto.setTitle("title");
        bookDto.setYear("2022");
        bookDto.setIsDeleted(false);

        ChapterDto chapterDto = new ChapterDto();
        chapterDto.setId(1L);
        chapterDto.setContent("content");
        chapterDto.setName("name");
        chapterDto.setIsDeleted(false);
        chapterDto.setBook(bookDto);
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        chapterDtoList.add(chapterDto);
        bookDto.setChapterDtoList(chapterDtoList);

        return bookDto;
    }
    
    public Book getBookSaved() {
        BookDto bookDto = getBookDto();

        Book book = new Book();
        book.setId(1L);
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setIsDeleted(false);

        List<Chapter> chapterList = new ArrayList<>();
        for (ChapterDto chapterDto2 : bookDto.getChapterDtoList()) {
            Chapter chapter = new Chapter();
            chapter.setIsDeleted(false);
            chapter.setContent(chapterDto2.getContent());
            chapter.setName(chapterDto2.getName());
            chapter.setBook(book);
            chapterList.add(chapter);
        }

        book.setChapterList(chapterList);

        return book;
    }
}
