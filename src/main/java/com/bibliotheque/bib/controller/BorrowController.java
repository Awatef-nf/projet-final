package com.bibliotheque.bib.controller;


import com.bibliotheque.bib.dto.BorrowCreateDto;
import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.model.Borrow;
import com.bibliotheque.bib.model.Members;
import com.bibliotheque.bib.services.BookServices;
import com.bibliotheque.bib.services.BorrowServices;
import com.bibliotheque.bib.services.MembersServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/borrow")
public class BorrowController {

        private BorrowServices borrowServices;


    public BorrowController(BorrowServices borrowServices) {
        this.borrowServices = borrowServices;
    }

        @GetMapping("/all")
        public List<Borrow> getAll() {
            return  borrowServices.getAllBorrow();
        }

        @GetMapping("/{id}")
        public Borrow getBorrowBuId(@PathVariable Integer id)
        {
            return borrowServices.getBorrrowById(id);
        }


        @PostMapping("/create")
        public Borrow createBorrow(@RequestBody BorrowCreateDto dto)
        {
            return borrowServices.createNewBorrow(dto);
        }

        @GetMapping("/inprogress")
        public List<Borrow> borrowInProgress()
        {
            return borrowServices.borrowInProgress();
        }

        @GetMapping("/islate")
        public List<Borrow> borrowIsLate()
        {
            return borrowServices.borrowIsLate();
        }

        @GetMapping("/member/{id}")
        public List<Borrow> borrowOfMember(@PathVariable Integer id)
        {
            return  borrowServices.BorrowOfMember(id);
        }

    }

