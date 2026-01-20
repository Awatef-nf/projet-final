package com.bibliotheque.bib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue

    public Integer id;

    private String name_;
    private String first_name;
    private String e_mail;
    private String telephone;
    private LocalDate registration_date;
    private boolean active_;


    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "members-borrow")
    private List<Borrow> Borrow;

    public Members() {
    }

    public Members(Integer id, String name_, String first_name, String e_mail, String telephone, LocalDate registration_date, boolean active_) {
        this.id = id;
        this.name_ = name_;
        this.first_name = first_name;
        this.e_mail = e_mail;
        this.telephone = telephone;
        this.registration_date = registration_date;
        this.active_ = active_;
    }

    public Members(String name_, String first_name, String e_mail, String telephone, LocalDate registration_date, boolean active_, Members members) {
        this.name_ = name_;
        this.first_name = first_name;
        this.e_mail = e_mail;
        this.telephone = telephone;
        this.registration_date = registration_date;
        this.active_ = active_;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Borrow> getBorrow() {
        return Borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        Borrow = borrow;
    }

    public boolean isActive_() {
        return active_;
    }

    public void setActive_(boolean active_) {
        this.active_ = active_;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }
}