package com.bibliotheque.bib.controller;

import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.services.BookServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class BookController {
    private BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

   @GetMapping("/")
    public List<Book> getAll() {
        return  bookServices.getAllaBook();

    }

    @GetMapping("/available")
    public List<Book> getAvailable(){
        return  bookServices.getAvailableBook();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable  Integer id){
        return  bookServices.getBookById(id);
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book b)
    {
        return bookServices.createNewBook( b);
    }


}
