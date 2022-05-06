package com.OneToMany.OneToMany.repository;
import com.OneToMany.OneToMany.dto.BookDto;
import com.OneToMany.OneToMany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(
            value = "SELECT new com.OneToMany.OneToMany.dto.BookDto(b.id,b.title,b.author,b.year,b.isDeleted)"+
                    "FROM Book b "+
                    "INNER JOIN Chapter c " +
                    "ON  c.book=b.id "
    )
    List<BookDto> getBook();

}
