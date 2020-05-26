package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.Book;
import com.ocr.citylibraryapi.repository.BookDao;
import com.ocr.citylibraryapi.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookRepositoryImpl bookRepoImpl;

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public List<Book> searchBookByAuthorOrTitle(String author, String title) {
        return bookRepoImpl.findBooksByAuthorOrTitle(author, title);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listBooks() { return bookDao.findAll();
    }

}
