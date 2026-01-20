package com.bibliotheque.bib.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "book-borrow")
    private List<Borrow> Borrow;


    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="isbn")
    private String isbn;

    @Column(name="year_published")
    private Integer year_published;

    @Column(name="categories")
    private String categories;

    @Column(name="copies_total")
    private Integer copies_total;

    @Column(name="copies_available")
    private Integer copies_available;

    public Book() {
    }

    public Book(String title, String author, String isbn, Integer year_published, String categories, Integer copies_total, Integer copies_avaible) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year_published = year_published;
        this.categories = categories;
        this.copies_total = copies_total;
        this.copies_available = copies_avaible;
    }



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<Borrow> getBorrow() {
        return Borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        Borrow = borrow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear_published() {
        return year_published;
    }

    public void setYear_published(Integer year_published) {
        this.year_published = year_published;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getCopies_total() {
        return copies_total;
    }

    public void setCopies_total(Integer copies_total) {
        this.copies_total = copies_total;
    }

    public Integer getCopies_available() {
        return copies_available;
    }

    public void setCopies_available(Integer copies_available) {
        this.copies_available = copies_available;
    }
}
