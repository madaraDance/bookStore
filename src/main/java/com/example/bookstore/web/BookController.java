package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.BOOK;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;



@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository cRepository;

    @RequestMapping("/index")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    // RESTful service to get all students
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<BOOK> bookListRest() {	
        return (List<BOOK>) repository.findAll();
    }

	// RESTful service to get student by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<BOOK> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }       

    @RequestMapping(value = "/add")
        public String addBook(Model model){
        model.addAttribute("book", new BOOK());
        model.addAttribute("categories", cRepository.findAll());
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
            model.addAttribute("categories", cRepository.findAll());
            return "editBook";
        } else {
            // If the book doesn't exist, handle the error gracefully
            // For example, you can redirect the user to the book list page with an error message
            return "redirect:/index";
        }
    }

    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}

}
