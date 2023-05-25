package com.example.week4day5.Service;

import com.example.week4day5.Model.Book;
import com.example.week4day5.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    //CRUD Start
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(int id,Book book){
        Book old = bookRepository.getBookById(id);
        old.setAuthor(book.getAuthor());
        old.setIsbn(book.getIsbn());
        old.setCategory(book.getCategory());
        old.setNumberOfPages(book.getNumberOfPages());
        old.setTitle(book.getTitle());
        bookRepository.save(old);
    }
    public void deleteBook(int id){
        bookRepository.delete(bookRepository.getBookById(id));
    }
    //CRUD Finished

    public List<Book> getBooksByCategory(String category){
        return bookRepository.getBooksByCategory(category);
    }
    public List<Book> getBooksByPages(Integer pages){
        return bookRepository.getBooksByNumberOfPagesGreaterThan(pages);
    }
    public List<Book> getBooksByAuthor(String author){
        return bookRepository.getBooksByAuthor(author);
    }
    public Book searchByTitle(String title){
        return bookRepository.getBookByTitle(title);
    }


}
