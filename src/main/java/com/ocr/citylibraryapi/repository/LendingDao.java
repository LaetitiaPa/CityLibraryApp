package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.Copy;
import com.ocr.citylibraryapi.entity.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingDao extends JpaRepository<Lending, Long> {

    @Query("SELECT l.copy.id FROM Lending l WHERE l.customer.id =:id ")
    List <Long> findCopyByCustomerId(@Param("id")Long id);
}
