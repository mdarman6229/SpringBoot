package com.api.books.Services;

import com.api.books.Dao.BookRepository;
import com.api.books.Entites.Author;
import com.api.books.Entites.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;



   /* private static List<Book> list=new ArrayList<>();

    static {
        list.add(new Book(12,"java references","CVG"));
        list.add(new Book(13,"java Developer...","ABC"));
        list.add(new Book(14,"Python programming ...","MNO"));

    }*/




    //get all books...
    public List<Book> getAllBook(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book=this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding the Book...
    public Book addBook(Book b){

        Book result=bookRepository.save(b);
        return result;
    }

    //Delete Book....
    public void deleteBook(int bid){
        //list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());

        bookRepository.deleteById(bid);
    }



    //Update(Create=POST) the Book...
    public void updateBook(Book book, int bookId) {

       /* list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;

        }).collect(Collectors.toList());*/
        Book book1 =null;
       try{

           book1.setTitle(book.getTitle());
           book1.setAuthor(book.getAuthor());
           bookRepository.save(book);

       } catch (Exception e) {
           e.printStackTrace();
       }

    }


       /* book.setId(bookId);
        System.out.println("Saving Book: " + book);
        Book result = bookRepository.save(book);
        System.out.println("Saved Book: " + result);
        bookRepository.save(book);

    @Transactional // Ensure transactional consistency
    public Book updateBook(Book book, int bookId) {
        Optional<Book> existingBookOpt = bookRepository.findById(bookId);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());

            return bookRepository.save(existingBook); // Save the merged changes
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }*/

}
