package com.onetoone.service;

import com.onetoone.dto.BookChapterGroupResponse;
import com.onetoone.dto.BookChapterResponse;
import com.onetoone.dto.BookDto;
import com.onetoone.dto.ChapterDto;
import com.onetoone.entity.Book;
import com.onetoone.entity.Chapter;
import com.onetoone.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto insert(BookDto bookDto) throws Exception {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setIsDeleted(false);

        List<Chapter> chapterList = new ArrayList<>();
        for (ChapterDto chapterDto : bookDto.getChapterDtoList()) {
            Chapter chapter = new Chapter();
            chapter.setIsDeleted(false);
            chapter.setContent(chapterDto.getContent());
            chapter.setName(chapterDto.getName());
            chapter.setBook(book);
            chapterList.add(chapter);
        }

        book.setChapterList(chapterList);

        Book bookInserted = bookRepository.save(book);

        if (bookInserted == null) {
            String errorMessage = "book is not successfully saved to db";
            throw new Exception(errorMessage);
        }

        BookDto bookDtoInserted = new BookDto();
        bookDtoInserted.setAuthor(bookInserted.getAuthor());
        bookDtoInserted.setTitle(bookInserted.getTitle());
        bookDtoInserted.setYear(bookInserted.getYear());
        bookDtoInserted.setId(bookInserted.getId());

        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (Chapter chapter : bookInserted.getChapterList()) {
            ChapterDto chapterDto = new ChapterDto();
            chapterDto.setId(chapter.getId());
            chapterDto.setIsDeleted(chapter.getIsDeleted());
            chapterDto.setContent(chapter.getContent());
            chapterDto.setName(chapter.getName());
            chapterDtoList.add(chapterDto);
        }

        bookDtoInserted.setChapterDtoList(chapterDtoList);
        bookDtoInserted.setIsDeleted(false);

        return bookDtoInserted;
    }

    @Override
    public List<BookChapterResponse> getBookChapter() {
        return this.bookRepository.getBookChapter();
    }

    @Override
    public List<BookChapterGroupResponse> getBookChapterGroup() throws Exception {
        List<BookChapterResponse> bookChapterResponseList = this.bookRepository.getBookChapter();

        if (bookChapterResponseList.size() == 0) {
            String messageError = "book chapter not found";
            throw new Exception(messageError);
        }

        // use fitur java8
        Map<String, List<BookChapterResponse>> mapBookChResp = bookChapterResponseList.stream().collect(groupingBy(BookChapterResponse::getName));

        List<BookChapterGroupResponse> bookChapterGroupResponseList = new ArrayList<>();
        BookChapterGroupResponse bookChapterGroupResponse = new BookChapterGroupResponse();
        for (Map.Entry<String, List<BookChapterResponse>> entry : mapBookChResp.entrySet()) {
            bookChapterGroupResponse.setName(entry.getKey());
            bookChapterGroupResponse.setBookChapter(entry.getValue());
            bookChapterGroupResponseList.add(bookChapterGroupResponse);

            bookChapterGroupResponse = new BookChapterGroupResponse();
        }

        return bookChapterGroupResponseList;
    }

    @Override
    public Integer getTotalBooks() {
        Integer totalBooks = 0;

        System.out.println("total buku = " + totalBooks);

        totalBooks = this.bookRepository.getTotalBooks();

        System.out.println("total buku = " + totalBooks);

        return totalBooks;
    }

}
