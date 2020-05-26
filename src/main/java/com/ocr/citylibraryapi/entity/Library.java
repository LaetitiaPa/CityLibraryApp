package com.ocr.citylibraryapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "library_id" )
    private Long   id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library")
    private List<Copy> copies;

    public Library() {
    }
}
