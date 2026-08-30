package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.restapi.entity.Book;
import com.springboot.restapi.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController 
{
	@Autowired
    private BookService service;

    // View Active Books
    @GetMapping
    public String viewBooks(Model model) 
    {
        model.addAttribute("books", service.getActiveBooks());
        return "book-list";
    }

    // Add Form
    @GetMapping("/add")
    public String addBook(Model model)
    {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // Save Book
    @PostMapping("/save")
    public String saveBook(
    		@Valid 
    		@ModelAttribute("book") Book book,
                           BindingResult result)
    {
        if(result.hasErrors()) 
        {
            return "add-book";
        }

        service.saveBook(book);
        return "redirect:/books";
    }

    // Edit Form
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model)
    {
        model.addAttribute("book", service.getBookById(id));
        return "edit-book";
    }

    // Update
    @PostMapping("/update")
    public String updateBook(
    		@Valid 
    		@ModelAttribute("book") Book book,
                             BindingResult result) 
    {
        if(result.hasErrors()) 
        {
            return "edit-book";
        }

        service.updateBook(book);
        return "redirect:/books";
    }

    // Soft Delete
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id)
    {
        service.softDelete(id);
        return "redirect:/books";
    }

    // Trash
    @GetMapping("/trash")
    public String trash(Model model)
    {
        model.addAttribute("books", service.getDeletedBooks());
        return "trash-books";
    }

    // Restore
    @GetMapping("/restore/{id}")
    public String restore(@PathVariable Long id) 
    {
        service.restoreBook(id);
        return "redirect:/books/trash";
    }

    // Permanent Delete
    @GetMapping("/permanent-delete/{id}")
    public String permanentDelete(@PathVariable Long id)
    {
        service.permanentDelete(id);
        return "redirect:/books/trash";
    }
}
