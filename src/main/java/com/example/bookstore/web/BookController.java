package com.example.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.BOOK;
import com.example.bookstore.domain.BookRepository;



@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping("/index")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/add")
        public String addStudent(Model model){
        model.addAttribute("book", new BOOK());
        return "addBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(BOOK book){
            repository.save(book);
            return "redirect:index";
        }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model){
        Optional<BOOK> bookOptional = repository.findById(bookId);
    
        // Check if the book exists in the database
        if (bookOptional.isPresent()) {
            // If the book exists, add it to the model
            model.addAttribute("book", bookOptional.get());
            return "editBook";
        } else {
            // If the book doesn't exist, handle the error gracefully
            // For example, you can redirect the user to the book list page with an error message
            return "redirect:/index";
        }
    }

}
