package com.ocr.citylibraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ocr.citylibraryapi.entity.Book;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long>, BookRepositoryCustom {

    @Query("SELECT b.title, b.author FROM Book b WHERE b.id = ?1 ")
    String findBookDetailsById(@Param("id")Long id);


}