package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.Customer;
import com.ocr.citylibraryapi.entity.Role;
import com.ocr.citylibraryapi.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping(value = "/customer/role", method = RequestMethod.GET)
    public Role findCustomerRolesByEmail(@RequestParam String email) { return customerDao.findCustomerRolesByEmail(email); }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer findCustomerByEmail(@RequestParam String email) { return customerDao.findByEmail(email); }
}
