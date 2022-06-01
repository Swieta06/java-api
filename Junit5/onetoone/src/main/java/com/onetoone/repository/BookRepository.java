package com.onetoone.repository;

import com.onetoone.dto.BookChapterResponse;
import com.onetoone.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT new com.onetoone.dto.BookChapterResponse(c.id, b.author, b.title, b.year, c.content, c.name) " +
            "from Book b JOIN Chapter c ON b.id=c.book")
    public List<BookChapterResponse> getBookChapter();

    @Query(value = "select COUNT(*) from book b " +
            "group by b.author", nativeQuery = true)
    public Integer getTotalBooks();
}
