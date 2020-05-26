package com.ocr.citylibraryapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ReminderList {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "reminder_id" )
    private Long   id;

    private String customerEmail;

    private String authorBook;

    private String titleBook;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lending_id")
    private Lending lending;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public Lending getLending() {
        return lending;
    }

    public void setLending(Lending lending) {
        this.lending = lending;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public ReminderList(String customerEmail, String authorBook, String titleBook) {
        this.customerEmail = customerEmail;
        this.authorBook = authorBook;
        this.titleBook = titleBook;
    }

    public ReminderList() {
    }
}
