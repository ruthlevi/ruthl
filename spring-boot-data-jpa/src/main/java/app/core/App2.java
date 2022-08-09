package app.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.core.dao.EmployeeDAO;
import app.core.entities.Book;
import app.core.entities.Employee;
import app.core.repositories.BookRepository;
import app.core.services.BookService;

@Component
public class App2 implements CommandLineRunner {

	@Autowired
	BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
//		doAddBook();
//		doGetBook(1);
//		doUpdate();
//		doDelete(1);
		doFindByAuthor("Ruth Levi");
	}

	private void doGetBook(int id) {
		Book book = bookService.getBook(id);
		System.out.println(book);
	}
	private void doAddBook() {
		Book book = new Book(0, "History", "Dan");
		bookService.addBook(book);
	}
	
	private void doUpdate() {
		Book book = new Book(1, "Java", "Ruth");
		bookService.updateBook(book);
	}
	
	private void doDelete(int id) {
		bookService.deleteBook(id);
	}
	
	public void doFindByAuthor(String author) {
		List<Book> books = bookService.getBooksByAuthor(author);
		System.out.println("===============");
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println("===============");

	}
	
}
