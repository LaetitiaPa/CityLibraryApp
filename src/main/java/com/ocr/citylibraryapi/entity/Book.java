package com.ocr.citylibraryapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Book {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "book_id" )
    private Long   id;

    private Long   isbn;

    private String author;

    private String title;

    private String summary;

    @DateTimeFormat( iso = DateTimeFormat.ISO.DATE )
    private Date   publishingDate;

    private String audience;

    private String genre;

    private String language;

    private String pictureBook;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Copy> copies;

    public Book(Long isbn, String author, String title, String summary, Date publishingDate, String audience, String genre, String language, String pictureBook) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.publishingDate = publishingDate;
        this.audience = audience;
        this.genre = genre;
        this.language = language;
        this.pictureBook = pictureBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", publishingDate=" + publishingDate +
                ", audience='" + audience + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", pictureBook='" + pictureBook + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public String getAudience() {
        return audience;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getPictureBook() {
        return pictureBook;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPictureBook(String pictureBook) {
        this.pictureBook = pictureBook;
    }


    public Book() {
    }
}
