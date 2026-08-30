package com.springboot.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>
{
    List<Book> findByDeletedFalse();

    List<Book> findByDeletedTrue();
}
