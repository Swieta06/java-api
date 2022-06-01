package com.onetoone.controller;

import com.onetoone.dto.BookChapterGroupResponse;
import com.onetoone.dto.BookDto;
import com.onetoone.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest extends Constants {
    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void insertTest() throws Exception {
        Mockito.when(this.bookService.insert(Mockito.any())).thenReturn(getBookSavedDto());

        ResponseEntity<BookDto> bookSavedDto = (ResponseEntity<BookDto>) bookController.insert(getBookDto());

        Assertions.assertEquals(bookSavedDto.getBody().getTitle(), getBookSavedDto().getTitle());
        Assertions.assertEquals(bookSavedDto.getBody().getAuthor(), getBookSavedDto().getAuthor());
        Assertions.assertEquals(bookSavedDto.getBody().getId(), getBookSavedDto().getId());
        Assertions.assertEquals(bookSavedDto.getBody().getYear(), getBookSavedDto().getYear());
        Assertions.assertEquals(bookSavedDto.getBody().getChapterDtoList().size(), getBookSavedDto().getChapterDtoList().size());
    }

    @Test
    public void insertErrorTest() throws Exception {
        Mockito.when(this.bookService.insert(Mockito.any())).thenThrow(new Exception("insertError"));

        ResponseEntity<?> response = bookController.insert(getBookDto());

        Assertions.assertEquals("insertError", response.getBody());
    }

    @Test
    public void getBookChapterGroupTest() throws Exception {
        BookChapterGroupResponse bookChapterGroupResponse = new BookChapterGroupResponse();
        bookChapterGroupResponse.setName("namee");

        List<BookChapterGroupResponse> bookChapterGroupResponseList = new ArrayList<>();
        bookChapterGroupResponseList.add(bookChapterGroupResponse);

        Mockito.when(this.bookService.getBookChapterGroup()).thenReturn(bookChapterGroupResponseList);

        ResponseEntity<List<BookChapterGroupResponse>> response = (ResponseEntity<List<BookChapterGroupResponse>>) bookController.getBookChapterGroup();

        Assertions.assertEquals("namee", response.getBody().get(0).getName());
    }

    @Test
    public void getBookChapterGroupErrorTest() throws Exception {
        Mockito.when(this.bookService.getBookChapterGroup()).thenThrow(new Exception("getBookChapterGroupError"));

        ResponseEntity<?> response = bookController.getBookChapterGroup();

        Assertions.assertEquals("getBookChapterGroupError", response.getBody());
    }
}
