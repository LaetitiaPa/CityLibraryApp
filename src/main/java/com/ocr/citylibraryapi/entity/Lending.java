package com.ocr.citylibraryapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lending {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "lending_id" )
    private Long   id;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    private boolean extension;

    private boolean bookReturn;

    private boolean tag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "copy_id")
    private Copy copy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    private Customer   customer;

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isExtension() {
        return extension;
    }

    public void setExtension(boolean extension) {
        this.extension = extension;
    }

    public boolean isBookReturn() {
        return bookReturn;
    }

    public void setBookReturn(boolean bookReturn) {
        this.bookReturn = bookReturn;
    }

    public boolean isTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }


    public Lending() {
    }


}
