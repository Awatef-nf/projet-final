package com.bibliotheque.bib.services;
import com.bibliotheque.bib.Repository.BorrowRepository;
import com.bibliotheque.bib.model.Borrow;
import org.springframework.stereotype.Service;


import java.util.List;
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

}

