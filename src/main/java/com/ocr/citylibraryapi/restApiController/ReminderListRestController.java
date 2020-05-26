package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.ReminderList;
import com.ocr.citylibraryapi.repository.ReminderListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReminderListRestController {

    @Autowired
    private ReminderListDao reminderListDao;

    @RequestMapping(value = "/Reminders", method = RequestMethod.GET)
    public List<ReminderList> listReminder() { return reminderListDao.findAll();
    }

    @RequestMapping(value = "/Email", method = RequestMethod.GET)
    public String findEmailByCustomerId(@RequestParam Long id) { return reminderListDao.findEmailByCustomerId(id);
    }
}
