package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.Lending;
import com.ocr.citylibraryapi.entity.ReminderList;
import com.ocr.citylibraryapi.repository.LendingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class LendingRestController {

    @Autowired
    LendingDao lendingDao;

    @RequestMapping(value = "/lendings", method = RequestMethod.GET)
    public List<Lending> listLending() {
        return lendingDao.findAll();
    }



}
