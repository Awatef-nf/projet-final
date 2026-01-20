package com.bibliotheque.bib.services;

import com.bibliotheque.bib.Repository.MembersRepository;
import com.bibliotheque.bib.model.Book;
import com.bibliotheque.bib.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersServices {
    @Autowired
    private MembersRepository membersRepository;

    private List<Members> listMembers = new ArrayList<>();

    public MembersServices(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public MembersServices() {
    }


    public List<Members> getAllaMembers()
    {
        return membersRepository.findAll();
    }

    public List<Members> getAvailableBook()
    {

        return listMembers;
    }

    public Members getMemberById(Integer id)
    {
        return membersRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("le membre avec l'" + id + " non trouvable")
                );
    }

    public Members createNewMember(Members m){
        return membersRepository.save(m);

    }

    public List<Members> activeMembers()
    {
        List<Members> active = new ArrayList<>();
        List<Members> all = membersRepository.findAll();

        for (Members m : all) {
            if (m.isActive_()) {
                active.add(m);
            }
        }
        return active;
    }


}
