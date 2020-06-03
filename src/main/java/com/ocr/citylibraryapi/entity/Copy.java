package com.ocr.citylibraryapi.entity;

import javax.persistence.*;

@Entity
public class Copy {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "copy_id" )
    private Long   id;

    private boolean availability;

    private int copies;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private Library library;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Copy(boolean availability) {
        this.availability = availability;
    }

    public Copy(boolean availability, Book book) {
        this.availability = availability;
        this.book = book;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }


    public Copy() {
    }
}
