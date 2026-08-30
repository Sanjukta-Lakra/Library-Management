package com.springboot.restapi.service;

import java.util.List;

import com.springboot.restapi.entity.Book;

public interface BookService 
{
	void saveBook(Book book);

    List<Book> getActiveBooks();

    Book getBookById(Long id);

    void updateBook(Book book);

    void softDelete(Long id);

    List<Book> getDeletedBooks();

    void restoreBook(Long id);

    void permanentDelete(Long id);
}
