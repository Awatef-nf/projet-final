package com.bibliotheque.bib.controller;


import com.bibliotheque.bib.dto.BorrowDto;
import com.bibliotheque.bib.model.Borrow;
import com.bibliotheque.bib.services.BorrowServices;
import org.springframework.web.bind.annotation.*;

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
        public List<BorrowDto> getAll() {
            return  borrowServices.getAllBorrow();
        }

        @GetMapping("/{id}")
        public Borrow getBorrowBuId(@PathVariable Integer id)
        {
            return borrowServices.getBorrrowById(id);
        }


        @PostMapping("/create")
        public Borrow createBorrow(@RequestBody BorrowDto dto)
        {
            return borrowServices.createNewBorrow(dto);
        }

        @GetMapping("/inprogress")
        public List<BorrowDto> borrowInProgress()
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

        @PostMapping("/{id}/tomodify")
        public Borrow ModifyBorrow(@RequestBody BorrowDto dto, @PathVariable Integer id)
        {
            return  borrowServices.modifyBorrow(dto,id);
        }
    }

