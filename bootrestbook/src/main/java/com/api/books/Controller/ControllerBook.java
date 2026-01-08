package com.api.books.Controller;

import com.api.books.Entites.Book;
import com.api.books.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerBook {

    @Autowired
    private BookService bookService;

    //get Book all Handler...
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookService.getAllBook();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
        return ResponseEntity.of(Optional.of(list));
    }


    //get Book by Single Handler....
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id) {
        Book book = this.bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //new Book handler...
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete Book Handler....
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //update the Book Handler...
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        try {
            Book existingBook = this.bookService.getBookById(bookId);
            if (existingBook == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            // Update only necessary fields
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());

            this.bookService.updateBook(existingBook, bookId);
            ResponseEntity.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


    }
}