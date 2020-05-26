package com.ocr.citylibraryapi.repository;

import java.util.List;

import com.ocr.citylibraryapi.entity.Book;

public interface BookRepositoryCustom {

    List<Book> findBooksByAuthorOrTitle( String author, String title );

}
