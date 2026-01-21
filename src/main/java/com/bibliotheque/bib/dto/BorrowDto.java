package com.bibliotheque.bib.dto;

import java.time.LocalDate;

public class BorrowDto {

    private Integer book_id;
    private Integer members_id;
    private LocalDate borrow_date;

    private LocalDate expected_return_date;

    private LocalDate effective_return_date;

    public BorrowDto(Integer book_id, Integer members_id, LocalDate borrow_date, LocalDate expected_return_date, LocalDate effective_return_date) {
        this.book_id = book_id;
        this.members_id = members_id;
        this.borrow_date = borrow_date;
        this.expected_return_date = expected_return_date;
        this.effective_return_date = effective_return_date;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getMembers_id() {
        return members_id;
    }

    public void setMembers_id(Integer members_id) {
        this.members_id = members_id;
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
