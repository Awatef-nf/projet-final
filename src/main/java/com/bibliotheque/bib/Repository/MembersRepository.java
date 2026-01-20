package com.bibliotheque.bib.Repository;

import com.bibliotheque.bib.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembersRepository extends JpaRepository<Members,Integer> {
}
