package com.onetoone.service;

import com.onetoone.dto.BookChapterGroupResponse;
import com.onetoone.dto.BookChapterResponse;
import com.onetoone.dto.BookDto;
import com.onetoone.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest extends Constants {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Test
    public void insertTest() throws Exception {
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBookSaved());

        BookDto bookDto = bookServiceImpl.insert(getBookDto());

        Assertions.assertEquals(getBookSaved().getAuthor(), bookDto.getAuthor());
        Assertions.assertEquals(getBookSaved().getId(), bookDto.getId());
        Assertions.assertEquals(getBookSaved().getTitle(), bookDto.getTitle());
    }

    @Test
    public void insertExceptionTest() throws Exception {
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(null);

        Assertions.assertThrows(Exception.class, () -> bookServiceImpl.insert(getBookDto()));
    }

    @Test
    public void getBookChapterGroupTest() throws Exception {
        BookChapterResponse bookChapterResponse = new BookChapterResponse();
        bookChapterResponse.setAuthor("author");
        bookChapterResponse.setContent("content123");
        bookChapterResponse.setId(1L);
        bookChapterResponse.setName("name");
        bookChapterResponse.setTitle("title");
        bookChapterResponse.setYear("2010");
        List<BookChapterResponse> bookChapterResponseList = new ArrayList<>();
        bookChapterResponseList.add(bookChapterResponse);

        Mockito.when(bookRepository.getBookChapter()).thenReturn(bookChapterResponseList);

        List<BookChapterGroupResponse> bookChapterGroupList = bookServiceImpl.getBookChapterGroup();

        Assertions.assertEquals(1, bookChapterGroupList.size());
        Assertions.assertEquals("content123", bookChapterGroupList.get(0).getBookChapter().get(0).getContent());
        Assertions.assertEquals("title", bookChapterGroupList.get(0).getBookChapter().get(0).getTitle());
        Assertions.assertEquals("author", bookChapterGroupList.get(0).getBookChapter().get(0).getAuthor());
    }

    @Test
    public void getBookChapterGroupExceptionTest() throws Exception {
        List<BookChapterResponse> bookChapterResponseList = new ArrayList<>();

        Mockito.when(bookRepository.getBookChapter()).thenReturn(bookChapterResponseList);

        Assertions.assertThrows(Exception.class, () -> bookServiceImpl.getBookChapterGroup());
    }

}
