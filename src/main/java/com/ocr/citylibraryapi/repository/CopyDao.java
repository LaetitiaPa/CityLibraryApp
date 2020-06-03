package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.Book;
import com.ocr.citylibraryapi.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyDao extends JpaRepository<Copy, Long>{

    @Query("SELECT c.copies FROM Copy c WHERE c.book.id = ?1 ")
    Long findCopiesByBookId(@Param("id")Long id);

    @Query("SELECT c.book.id FROM Copy c WHERE c.id = ?1 ")
    Long findBookByCopyId(@Param("id")Long id);

}