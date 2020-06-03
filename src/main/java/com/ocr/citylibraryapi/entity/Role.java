package com.ocr.citylibraryapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "role_id" )
    private Long   id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }
}
