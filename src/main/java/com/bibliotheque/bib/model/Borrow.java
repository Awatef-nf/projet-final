package com.bibliotheque.bib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "members_id")
    @JsonBackReference(value = "members-borrow")
    private Members members;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-borrow")
    private Book book;

    private Date borrow_date;

    private Date expected_return_date;

    private Date effective_return_date;



    public Borrow() {
    }

    public Borrow(Integer id, Date borrow_date, Date expected_return_date, Date effective_return_date) {
        this.id = id;
        this.borrow_date = borrow_date;
        this.expected_return_date = expected_return_date;
        this.effective_return_date = effective_return_date;
    }

    public Borrow(Date borrow_date, Date expected_return_date, Date effective_return_date) {
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

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getExpected_return_date() {
        return expected_return_date;
    }

    public void setExpected_return_date(Date expected_return_date) {
        this.expected_return_date = expected_return_date;
    }

    public Date getEffective_return_date() {
        return effective_return_date;
    }

    public void setEffective_return_date(Date effective_return_date) {
        this.effective_return_date = effective_return_date;
    }
}