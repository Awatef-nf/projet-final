package com.bibliotheque.bib.services;
import com.bibliotheque.bib.Repository.BorrowRepository;
import com.bibliotheque.bib.model.Borrow;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BorrowServices {

     private BorrowRepository borrowRepository;

    public BorrowServices(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> getAllBorrow() {
        return  borrowRepository.findAll();
        }

    public Borrow getBorrrowById(Integer id)   {
        return borrowRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("l'emprunt  avec l'" + id + " non trouvable")
                );

    }

    public Borrow createNewBorrow(Borrow b) {
        return borrowRepository.save(b);
    }


    public List<Borrow> borrowInProgress()
    {
        List<Borrow> borrowInProgress = new ArrayList<>();
        List<Borrow> borrows = borrowRepository.findAll();
        for(Borrow b : borrows)
        {
           
            if(b.getEffective_return_date()== null)
            {
                borrowInProgress.add(b);
            }
        }
        return borrowInProgress;
    }

    public List<Borrow> borrowIsLate()
    {
        List<Borrow> borrowIsLate= new ArrayList<>();
        List<Borrow> borrows = borrowRepository.findAll();
        for(Borrow b : borrows)
        {
            if((b.getExpected_return_date().isBefore(LocalDate.now()))&&(b.getEffective_return_date()==null))
            {
                borrowIsLate.add(b);
            }
        }return borrowIsLate;
    }

    public List<Borrow> BorrowOfMember(Integer id)
    {
        List<Borrow> borrowOfMember= new ArrayList<>();
        List<Borrow> borrows = borrowRepository.findAll();
        for(Borrow b : borrows)
        {
            if(b.getMembers().getId().equals(id))
            {
                borrowOfMember.add(b);
            }

        } return borrowOfMember;
    }


}



