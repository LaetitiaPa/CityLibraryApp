package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingDao extends JpaRepository<Lending, Long> {

}
