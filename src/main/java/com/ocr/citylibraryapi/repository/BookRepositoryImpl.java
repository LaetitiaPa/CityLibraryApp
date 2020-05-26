package com.ocr.citylibraryapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ocr.citylibraryapi.entity.Book;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<com.ocr.citylibraryapi.entity.Book> findBooksByAuthorOrTitle( String author, String title ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery( Book.class );

        Root<Book> book = cq.from( Book.class );
        List<Predicate> predicates = new ArrayList<>();

        if ( author != null && !author.isEmpty() ) {
            predicates.add( cb.like( book.get( "author" ), "%" + author + "%" ) );
        }
        if ( title != null && !title.isEmpty() ) {
            predicates.add( cb.like( book.get( "title" ), "%" + title + "%" ) );
        }
        cq.where( predicates.toArray( new Predicate[0] ) );

        return em.createQuery( cq ).getResultList();
    }

}
