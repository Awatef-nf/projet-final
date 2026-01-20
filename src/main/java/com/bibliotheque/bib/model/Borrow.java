package com.bibliotheque.bib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow")

public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "members_id")
    @JsonBackReference(value = "members-borrow")
    private Members members;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-borrow")
    private Book book;

    private LocalDate borrow_date;

    private LocalDate expected_return_date;

    private LocalDate effective_return_date;



    public Borrow() {
    }


    public Borrow(Members members, Book book, LocalDate borrow_date, LocalDate expected_return_date, LocalDate effective_return_date) {
        this.members = members;
        this.book = book;
        this.borrow_date = borrow_date;
        this.expected_return_date = expected_return_date;
        this.effective_return_date = effective_return_date;
    }

    public Borrow(Integer id, LocalDate borrow_date, LocalDate expected_return_date, LocalDate effective_return_date) {
        this.id = id;
        this.borrow_date = borrow_date;
        this.expected_return_date = expected_return_date;
        this.effective_return_date = effective_return_date;
    }

    public Borrow(LocalDate borrow_date, LocalDate expected_return_date, LocalDate effective_return_date) {
        this.borrow_date = borrow_date;
        this.expected_return_date = expected_return_date;
        this.effective_return_date = effective_return_date;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getExpected_return_date() {
        return expected_return_date;
    }

    public void setExpected_return_date(LocalDate expected_return_date) {
        this.expected_return_date = expected_return_date;
    }

    public LocalDate getEffective_return_date() {
        return effective_return_date;
    }

    public void setEffective_return_date(LocalDate effective_return_date) {
        this.effective_return_date = effective_return_date;
    }
}