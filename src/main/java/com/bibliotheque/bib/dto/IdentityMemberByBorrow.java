package com.bibliotheque.bib.dto;

import java.time.LocalDate;
import java.util.List;

public class IdentityMemberByBorrow {

    private String name_;
    private List<BorrowDto> listBorrowDto;
    private String first_name;

    public IdentityMemberByBorrow(List<BorrowDto> listBorrowDto, String name_,String first_name) {
        this.listBorrowDto = listBorrowDto;
        this.name_ = name_;
        this.first_name= first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public List<BorrowDto> getListBorrowDto() {
        return listBorrowDto;
    }

    public void setListBorrowDto(List<BorrowDto> listBorrowDto) {
        this.listBorrowDto = listBorrowDto;
    }
}
