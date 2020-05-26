package com.ocr.citylibraryapi.service;

import com.ocr.citylibraryapi.entity.Lending;
import com.ocr.citylibraryapi.entity.ReminderList;
import com.ocr.citylibraryapi.repository.LendingDao;
import com.ocr.citylibraryapi.repository.ReminderListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class MailService {

    @Autowired
    LendingDao lendingDao;






}
