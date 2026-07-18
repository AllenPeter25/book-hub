package com.example.books_service.repository;

import com.example.books_service.entity.Book;
import com.example.books_service.enums.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);


    @Query("""
        SELECT b
        FROM Book b
        WHERE
            (:author IS NULL OR b.author = :author)
        AND
            (:title IS NULL OR b.title = :title)
        AND
            (:category IS NULL OR b.bookCategory = :category)
    """)
    List<Book> querySearch(@Param("author") String author, @Param("title") String title,@Param("category") BookCategory category);
}
