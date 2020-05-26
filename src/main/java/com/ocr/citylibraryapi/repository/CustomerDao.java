package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.Customer;
import com.ocr.citylibraryapi.entity.ReminderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {


}
