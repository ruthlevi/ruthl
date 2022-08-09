package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByAuthor(String author);
	
	//SQL Query
	@Query(value= "select * from book where id=:id", nativeQuery = true)
	Book x1(int id);
	
	//JPQL Query
	@Query("from Book where Book.id=:id")
	Book x2(int id);
}
