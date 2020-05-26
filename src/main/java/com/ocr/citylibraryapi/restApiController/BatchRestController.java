package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.*;
import com.ocr.citylibraryapi.repository.BookDao;
import com.ocr.citylibraryapi.repository.LendingDao;
import com.ocr.citylibraryapi.repository.ReminderListDao;
import com.ocr.citylibraryapi.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@RestController
public class BatchRestController {

    @Autowired
    LendingDao lendingDao;

    @Autowired
    ReminderListDao reminderDao;

    @Autowired
    BookServiceImpl bookServiceImpl;

    @Autowired
    BookDao bookDao;

    @Autowired
    ReminderListDao reminderListDao;

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/updates", method = RequestMethod.GET)

    public void updateTag () {
        List<Lending> lendings = lendingDao.findAll();

        for (int i = 0; i < lendings.size(); i++) {
            Date currentDate = new Date();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
            Date dateFromLocalDT = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            Date date1 = lendings.get(i).getReservationDate();
            Lending currentLending = lendings.get(i);

            if (date1.before(dateFromLocalDT)) {
                currentLending.setTag(true);
                lendingDao.save(currentLending);
            }
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void addCustomerToReminderList() {

        List<Lending> allLending = lendingDao.findAll();
        for(int i = 0; i < allLending.size(); i++ ) {
            Lending currentLending = allLending.get(i);
            Customer customer = currentLending.getCustomer();

            if(currentLending.isTag() == true ) {
                ReminderList reminder = new ReminderList();
                reminder.setCustomerEmail(customer.getEmail());
                Copy ownedCopy = currentLending.getCopy();
                Long copyId = ownedCopy.getId();
                Book detailBook = bookServiceImpl.findById(copyId);
                reminder.setAuthorBook(detailBook.getAuthor());
                reminder.setTitleBook(detailBook.getTitle());
                reminder.setLending(currentLending);
                reminder.setCustomer(customer);
                reminderDao.save(reminder);

            }
        }

    }

    @RequestMapping(value = "/list/update", method = RequestMethod.GET)
    public void updateReminderList() {


    }

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public void sendEmail() {
        List<ReminderList> reminders = reminderListDao.findAll();
        SimpleMailMessage msg = new SimpleMailMessage();
        for (int i = 0; i < reminders.size(); i++) {
            ReminderList customer = reminders.get(i);
            msg.setTo(customer.getCustomerEmail());
            msg.setSubject("Testing from Spring Boot");
            msg.setText("Hello World \n Spring Boot Email");
            javaMailSender.send(msg);
        }

    }
}
