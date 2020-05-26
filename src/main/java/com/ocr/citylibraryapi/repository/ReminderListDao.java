package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.ReminderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderListDao extends JpaRepository<ReminderList, Long> {

    @Query("SELECT r.customerEmail FROM ReminderList r WHERE r.customer.id = ?1 ")
    String findEmailByCustomerId(@Param("id")Long id);


}
