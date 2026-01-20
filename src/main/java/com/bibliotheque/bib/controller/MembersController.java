package com.bibliotheque.bib.controller;
import com.bibliotheque.bib.model.Members;
import com.bibliotheque.bib.services.MembersServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin
@RestController
@RequestMapping("/members")
public class MembersController {
    private MembersServices membersServices;

    public MembersController(MembersServices membersServices) {
        this.membersServices = membersServices;
    }

    @GetMapping("/all")
    public List<Members> getAll() {
        return  membersServices.getAllaMembers();

    }


    @GetMapping("/{id}")
    public Members getMemberById(@PathVariable Integer id){
        return  membersServices.getMemberById(id);
    }

    @PostMapping("/create")
    public Members createNewMember(@RequestBody Members m)
    {
        return membersServices.createNewMember( m);
    }


    @GetMapping("/active")
    public List<Members> activeMembers()
    {
        return membersServices.activeMembers();
    }

}