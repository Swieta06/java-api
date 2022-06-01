package com.OneToMany.OneToMany.service;

import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.dto.ChapterDto;
import com.OneToMany.OneToMany.repository.BookRepository;
import com.OneToMany.OneToMany.service.impl.BookServiceImpl;
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
public class BookServiceImplTest extends constant{
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookServiceImpl bookServiceImpl;
    @Test
    public void insertTest(){
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBookSaved());

        BookDto bookDto = bookServiceImpl.insert(getBookDto());

        Assertions.assertEquals(getBookSaved().getAuthor(), bookDto.getAuthor());
        Assertions.assertEquals(getBookSaved().getId(), bookDto.getId());
        Assertions.assertEquals(getBookSaved().getTitle(), bookDto.getTitle());
    }
}
