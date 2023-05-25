package com.example.week4day5.Controller;

import com.example.week4day5.Model.Book;
import com.example.week4day5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id,@Valid @RequestBody Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body("Book updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book Deleted");
    }
    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBooksByCategory(category));
    }
    @GetMapping("/get-by-pages")
    public ResponseEntity getByPages(){
        return ResponseEntity.status(200).body(bookService.getBooksByPages(300));
    }
    @GetMapping("/get-by-author/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBooksByAuthor(author));
    }
    @GetMapping("/search/{title}")
    public ResponseEntity search(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.searchByTitle(title));
    }
}
