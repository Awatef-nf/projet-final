package com.bibliotheque.bib.services;

import com.bibliotheque.bib.Repository.MembersRepository;
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


}
