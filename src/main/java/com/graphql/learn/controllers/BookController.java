package com.graphql.learn.controllers;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/books")*/
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
   /* @PostMapping*/
    @MutationMapping("createBook")
    public Book create(/*@RequestBody Book*/@Argument BookInput book){
        Book b = new Book();
        b.setAuthor(book.getAuthor());
        b.setDesc(book.getDesc());
        b.setPages(book.getPages());
        b.setTitle(book.getTitle());
        b.setPrice(book.getPrice());
        return this.bookService.create(b);
    }

    /*@GetMapping*/
    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    /*@GetMapping("/{bookId}")*/
    @QueryMapping("getBook")
    public Book get(/*@PathVariable*/ @Argument int bookId){
        return this.bookService.get(bookId);
    }
}
@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
