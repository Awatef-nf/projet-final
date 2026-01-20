package com.bibliotheque.bib.services;
import com.bibliotheque.bib.Repository.BookRepository;
import com.bibliotheque.bib.Repository.BorrowRepository;
import com.bibliotheque.bib.Repository.MembersRepository;
import com.bibliotheque.bib.dto.BorrowCreateDto;
import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.model.Borrow;
import com.bibliotheque.bib.model.Members;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
     @Autowired
     private BookServices bookServices;
     @Autowired
     private MembersServices membersServices;

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

    public Borrow createNewBorrow(BorrowCreateDto dto) {
        Members member = membersServices.getMemberById(dto.getMembers_id());
        Book book =  bookServices.getBookById(dto.getMembers_id());
        Borrow newBorrow = new Borrow(member,book,dto.getBorrow_date(),dto.getExpected_return_date(),dto.getEffective_return_date());

        return borrowRepository.save(newBorrow);
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

    public Borrow modifyNewBorrow(BorrowCreateDto dto, Integer id) {


        Borrow borrowToModify = getBorrrowById(id);
        if(dto.getMembers_id() != null)
        {
            Members member = membersServices.getMemberById(dto.getMembers_id());
            borrowToModify.setMembers(member);

        } else if (dto.getBook_id() != null)
        {
            Book book =  bookServices.getBookById(dto.getMembers_id());
            borrowToModify.setBook(book);
        } else if ( dto.getExpected_return_date() != null) {
            borrowToModify.setExpected_return_date(dto.getExpected_return_date());

        }

        return borrowRepository.save(borrowToModify);
    }




}



