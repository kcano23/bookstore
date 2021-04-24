package kevincano.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kevincano.models.Books;
import kevincano.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	
	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	 public List<Books> allBooks() {
	        return this.bookRepository.findAll();
	    }
	    // creates a book
	    public Books createBook(Books b) {
	        return this.bookRepository.save(b);
	    }
	    // retrieves a book
	    public Books findBook(Long id) {
	        Optional<Books> optionalBook = this.bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    //update a book
	    public Books updateBooks(Long id, String title, String description, String language, Integer numOfPages ) {
	    	Books toUpdate = this.bookRepository.findById(id).orElse(null);
	    	if(toUpdate == null) {
	    		return null;
	    	}else {
	    		toUpdate.setTitle(title);
	    		toUpdate.setDescription(description);
	    		toUpdate.setLanguage(language);
	    		toUpdate.setNumberOfPages(numOfPages);
	    		return this.bookRepository.save(toUpdate);
	    	}
	    }
	    //overloading for updatePet
	    public Books updateBooks(Books book) {
	    	return this.bookRepository.save(book);
	    }
	    
	    //delete a book
	    public void deleteBook(Long id) {
	    	this.bookRepository.deleteById(id);
	    }
}
