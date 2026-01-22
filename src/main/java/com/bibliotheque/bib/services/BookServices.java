package com.bibliotheque.bib.services;

import com.bibliotheque.bib.Repository.BookRepository;
import com.bibliotheque.bib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    private List<Book> listBook = new ArrayList<>();
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookServices() {
    }

    public List<Book> getAllaBook()
    {
        return bookRepository.findAll();
    }

    public List<Book> getAvailableBook()
    {
        for(Book b: bookRepository.findAll())
        {
            if(b.getCopies_available()>0)
            {
                listBook.add(b);
            }
        }
        return listBook;
    }

    public Book getBookById(Integer id)
    {
        return bookRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("le livre avec l'" + id + " non trouvable")
                );
    }

    public List<Book> getBookByTitle( String title){
        List<Book> books = bookRepository.findAll();
        List<Book> booksearched = new ArrayList<>();

        for(Book b : books)
        {
            if(b.getTitle().toLowerCase().equals(title)) {
            booksearched.add(b);
        }
        }
        return booksearched;
    }


    public Book createNewBook(Book b){
       return bookRepository.save(b);

    }

    public List<Book> getByCategories(String categorie) {
        List<Book>  bookCategorie = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book b : books) {
            if (b.getCategories().equals(categorie)) {
                bookCategorie.add(b);
            }
        }
        return bookCategorie;
    }
}
