package com.bibliotheque.bib.controller;

import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

   @GetMapping("/all")
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

    @GetMapping("/categorie/{categories}")
    public  List<Book> getByCategorie(@PathVariable String categories)
    {
        return bookServices.getByCategories(categories);
    }


}
