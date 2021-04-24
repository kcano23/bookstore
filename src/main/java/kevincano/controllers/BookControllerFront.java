package kevincano.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kevincano.models.Books;
import kevincano.services.BookService;

@Controller
public class BookControllerFront {
	private final BookService bookService;
	
	public BookControllerFront(BookService service) {
		this.bookService = service;
	}
	  @RequestMapping("/books")
	    public String index(Model model) {
//	        List<Books> books = this.bookService.allBooks();
	        model.addAttribute("books", this.bookService.allBooks());
	        return "index.jsp";
	    }
	  @RequestMapping("/books/new")
	    public String newBook(@ModelAttribute("book") Books book) {
	        return "new.jsp";
	    }
	    @RequestMapping(value="/books/create", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("book") Books book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	            this.bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
	    @RequestMapping(value="/books/{id}")
	    public String bookDetail(@PathVariable("id") Long id, Model model) {
	    	Books book = bookService.findBook(id);
	    	model.addAttribute("book", book);
	    	return "onebook.jsp";
	    }
	    
	    @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Books book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "edit.jsp";
	    }
	    @RequestMapping(value="/books/{id}/update", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("book") Books book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            this.bookService.updateBooks(book);
	            return "redirect:/books";
	        }
	  
	    }
	    @RequestMapping(value="/books/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        this.bookService.deleteBook(id);
	        return "redirect:/books";
	    }
}
