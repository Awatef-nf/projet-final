package com.bibliotheque.bib.services;
import com.bibliotheque.bib.Repository.BorrowRepository;
import com.bibliotheque.bib.dto.BorrowDto;
import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.model.Borrow;
import com.bibliotheque.bib.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<BorrowDto> getAllBorrow() {
        List<Borrow> list = borrowRepository.findAll();
        List<BorrowDto> newList = new ArrayList<>();
        for (Borrow b : list) {
            newList.add(new BorrowDto(b.getBook().getId(),b.getMembers().getId(),b.getBorrow_date(),b.getExpected_return_date(),b.getEffective_return_date()));
        }
        return newList;
    }

    public Borrow getBorrrowById(Integer id)   {
        return borrowRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("l'emprunt  avec l'" + id + " non trouvable")
                );

    }

    public Borrow createNewBorrow(BorrowDto dto) {
        Members member = membersServices.getMemberById(dto.getMembers_id());
        Book book =  bookServices.getBookById(dto.getMembers_id());
        Borrow newBorrow = new Borrow(member,book,dto.getBorrow_date(),dto.getExpected_return_date(),dto.getEffective_return_date());

        return borrowRepository.save(newBorrow);
    }


    public List<BorrowDto> borrowInProgress()
    {

        List<BorrowDto> borrowInProgress = new ArrayList<>();
        List<Borrow> borrows = borrowRepository.findAll();
        for(Borrow b : borrows)
        {
           
            if(b.getEffective_return_date()== null)
            {
               borrowInProgress.add(new BorrowDto(b.getBook().getId(),b.getMembers().getId(),b.getBorrow_date(),b.getExpected_return_date(),b.getEffective_return_date()));
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

    public Borrow modifyBorrow(BorrowDto dto, Integer id) {

        Borrow borrowToModify = getBorrrowById(id);
        if(dto.getMembers_id() != null)
        {
            Members member = membersServices.getMemberById(dto.getMembers_id());
            borrowToModify.setMembers(member);

        } else if (dto.getBook_id() != null)
        {
            Book book =  bookServices.getBookById(dto.getMembers_id());
            borrowToModify.setBook(book);
        }
        else if (dto.getBorrow_date() != null) {
            borrowToModify.setBorrow_date(dto.getBorrow_date());
        }
        else if ( dto.getExpected_return_date() != null) {
            borrowToModify.setExpected_return_date(dto.getExpected_return_date());

        } else if (dto.getEffective_return_date() != null) {
            borrowToModify.setEffective_return_date(dto.getEffective_return_date());

        }
        return borrowRepository.save(borrowToModify);
    }




}



