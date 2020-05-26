package com.ocr.citylibraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocr.citylibraryapi.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long>, BookRepositoryCustom {

}