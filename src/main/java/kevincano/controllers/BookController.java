package kevincano.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kevincano.models.Books;
import kevincano.services.BookService;



@RestController
@RequestMapping("/api")
public class BookController {
	 private final BookService bookService;
	 public BookController(BookService bookService) {
		 this.bookService = bookService;
	 }
	 
	 
	@RequestMapping("/home")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping("/all")
	public List<Books> getAllBooks(){
		return this.bookService.allBooks();
	}
	
	  @RequestMapping(value="/create", method=RequestMethod.POST)
    public Books create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Books book = new Books(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
	  @RequestMapping("/books/{id}")
	    public Books show(@PathVariable("id") Long id) {
	        Books book = bookService.findBook(id);
	        return book;
	}
	  @RequestMapping(value="/books/{id}/update", method=RequestMethod.PUT)
	  public Books update(@PathVariable("id") Long id,  @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		  return this.bookService.updateBooks(id, title, desc, lang, numOfPages);
	  }
	  @RequestMapping(value="/books/{id}/delete", method=RequestMethod.DELETE)
	  public void delete(@PathVariable("id") Long id) {
		  this.bookService.deleteBook(id);
	  }

	
}
