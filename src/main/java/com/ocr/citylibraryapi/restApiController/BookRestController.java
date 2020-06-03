package com.ocr.citylibraryapi.restApiController;

import com.ocr.citylibraryapi.entity.Book;
import com.ocr.citylibraryapi.entity.Customer;
import com.ocr.citylibraryapi.entity.Role;
import com.ocr.citylibraryapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    @Autowired
    private BookRepositoryImpl bookRepoImpl;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CopyDao copyDao;

    @Autowired
    private LendingDao lendingDao;

    @Autowired
    CustomerDao customerDao;


    // Find a book by its author or title
    @RequestMapping(value = "/book/search-result", method = RequestMethod.GET)
    public List<Book> searchBookByAuthorOrTitle(String author, String title) {
        return bookRepoImpl.findBooksByAuthorOrTitle(author, title); }

        // Display all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listBooks() { return bookDao.findAll(); }

    // Find a book by Id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Optional<Book> book(@PathVariable Long id) { return bookDao.findById(id);}

    // Find copies by book
    @RequestMapping(value = "/book/{id}/copy", method = RequestMethod.GET)
    public Long bookCopies(@PathVariable Long id) { return copyDao.findCopiesByBookId(id);}

    // Display books owned by a customer
    @RequestMapping(value = "/customer/{id}/lending", method = RequestMethod.GET)
    public List <String> CustomerLending(@PathVariable Long id) {
        List <Long> copyId = lendingDao.findCopyByCustomerId(id);
        ArrayList<String> booklist = new ArrayList<>();

       for (int i = 0; i < copyId.size(); i++) {
           Long bookId = copyDao.findBookByCopyId(copyId.get(i));
           String book = bookDao.findBookDetailsById(bookId);
           booklist.add(book);
       }
        return booklist;
    }




}
