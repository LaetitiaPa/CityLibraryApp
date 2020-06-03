package com.ocr.citylibraryapi.repository;

import com.ocr.citylibraryapi.entity.Customer;
import com.ocr.citylibraryapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query("SELECT c.roles FROM Customer c WHERE c.email =:email ")
    Role findCustomerRolesByEmail(@Param("email")String email);

    Customer findByEmail(String email);

}
