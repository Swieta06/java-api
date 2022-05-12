package com.OneToMany.OneToMany.repository;
import com.OneToMany.OneToMany.dto.BookChapterResponse;
import com.OneToMany.OneToMany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


    @Query("SELECT new com.OneToMany.OneToMany.dto.BookChapterResponse(b.author,b.title, b.year, c.content,c.name)" +
            "from Book b " +
            "join Chapter c " +
            "ON b.id=c.book")
    public List<BookChapterResponse> getBookChapter();

}
