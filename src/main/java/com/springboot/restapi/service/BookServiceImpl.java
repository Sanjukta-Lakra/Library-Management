package com.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.entity.Book;
import com.springboot.restapi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository repository;

	@Override
	public void saveBook(Book book) 
	{
		book.setDeleted(false);
        repository.save(book);
	}

	@Override
	public List<Book> getActiveBooks()
	{
		return repository.findByDeletedFalse();
	}

	@Override
	public Book getBookById(Long id) 
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	public void updateBook(Book book) 
	{
		repository.save(book);
	}

	@Override
	public void softDelete(Long id)
	{
		Book book=repository.findById(id).orElse(null);

        if(book!=null)
        {
            book.setDeleted(true);
            repository.save(book);
        }
	}

	@Override
	public List<Book> getDeletedBooks() 
	{
		return repository.findByDeletedTrue();
	}

	@Override
	public void restoreBook(Long id)
	{
		Book book=repository.findById(id).orElse(null);

        if(book!=null)
        {
            book.setDeleted(false);
            repository.save(book);
        }
	}

	@Override
	public void permanentDelete(Long id) 
	{
		repository.deleteById(id);
	}
}
