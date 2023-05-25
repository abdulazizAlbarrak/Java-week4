package com.example.week4day5.Repository;

import com.example.week4day5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book getBookById(Integer id);
    List<Book> getBooksByCategory(String category);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByNumberOfPagesGreaterThan(Integer pages);
    Book getBookByTitle(String title);
}
