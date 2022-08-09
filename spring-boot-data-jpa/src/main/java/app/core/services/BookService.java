package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Book;
import app.core.repositories.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public int addBook(Book book) {
		if(!repo.existsById(book.getId())) {
			book = repo.save(book);
			return book.getId();
		} else {
			throw new RuntimeException("save failed - already exist");
		}
		
	}
	
	public Book getBook(int bookId) {
		return repo.findById(bookId).orElseThrow();
	}
	
	public List<Book> getBooksByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	
	public void updateBook(Book book) {
		if(repo.existsById(book.getId())) {
			repo.save(book);
		} else {
			throw new RuntimeException("update failed - not exist");
		}
		
	}
	public void deleteBook(int id) {
		repo.deleteById(id);
	}
}
