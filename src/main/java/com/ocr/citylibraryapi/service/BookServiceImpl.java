package com.ocr.citylibraryapi.service;

import com.ocr.citylibraryapi.entity.Book;
import com.ocr.citylibraryapi.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Book findById(Long id ) {
        return bookDao.getOne( id );
    }
}
