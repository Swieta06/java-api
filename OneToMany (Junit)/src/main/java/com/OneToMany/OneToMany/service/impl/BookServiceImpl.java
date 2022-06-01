package com.OneToMany.OneToMany.service.impl;

import com.OneToMany.OneToMany.dto.BookChapterResponse;
import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.dto.ChapterDto;
import com.OneToMany.OneToMany.model.Book;
import com.OneToMany.OneToMany.model.Chapter;
import com.OneToMany.OneToMany.repository.BookRepository;
import com.OneToMany.OneToMany.service.BookService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookDto insert(BookDto bookDto) {
        Book book=new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());
        book.setIsDeleted(false);

            //ini list chapter
            List<Chapter>chapterList=new ArrayList<>();
            for (ChapterDto chapterDto:bookDto.getChapterDtoList()){
                Chapter chapter=new Chapter();
                chapter.setName(chapterDto.getName());
                chapter.setContent(chapterDto.getContent());
                chapter.setIsDeleted(false);
                chapter.setBook(book);
                chapterList.add(chapter);
            }

        book.setChapterList(chapterList);

        Book bookInserted=bookRepository.save(book);

        BookDto bookDtoInserted=new BookDto();
        bookDtoInserted.setAuthor(bookInserted.getAuthor());
        bookDtoInserted.setTitle(bookInserted.getTitle());
        bookDtoInserted.setYear(bookInserted.getYear());
        bookDtoInserted.setId(bookInserted.getId());
        //ini list chapterdto
            List<ChapterDto>chapterDtoList=new ArrayList<>();
            for (Chapter chapter:bookInserted.getChapterList()){
                ChapterDto chapterDto=new ChapterDto();
                chapterDto.setName(chapter.getName());
                chapterDto.setContent(chapter.getContent());
                chapterDto.setIsDeleted(chapter.getIsDeleted());

                chapterDtoList.add(chapterDto);
            }

        bookDtoInserted.setChapterDtoList(chapterDtoList);

        return bookDtoInserted;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<BookChapterResponse> getBookChapter() {
        return this.bookRepository.getBookChapter();
    }


}
