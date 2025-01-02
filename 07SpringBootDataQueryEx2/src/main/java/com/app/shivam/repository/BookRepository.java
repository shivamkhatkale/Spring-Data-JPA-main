package com.app.shivam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.shivam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

//	// SQL : select * from booktab where author like ?
	@Query("SELECT b FROM Book b WHERE b.author = ?1")
	List<Book> getBooksByAuthor(@Param("author") String author);

	// SQL : SELECT * FROM BOOKTAB WHERE AUTHOR LIKE ? AND bcost > ?
	@Query("SELECT b FROM Book b WHERE b.author like ?1 AND b.bookCost > ?2 OR b.bookType=?3") // :author OR (?1) |
																								// ::bookCost OR (?2)
	List<Book> getBooksByAuthorLikeBookCost(String author, Double bcostbookCost);

	// SQL : SELECT * FROM booktab where bid in (?,?,?)
	@Query("SELECT b FROM Book b WHERE b.bookId in (?1)")
	List<Book> getListofBookId(List<Integer> bids);

	List<Book> findBybookTypeLike(String bookType);

	@Query("SELECT b FROM Book b WHERE b.bookId = :bookId") // corrected the syntax error here
	Book findBybook(Integer bookId);

	// SQL : Write a JPQL query to fetch all Book entities with name and author
	// fields.
	@Query("SELECT b.bookName, b.author FROM Book b")
	List<Object[]> findByAllBook();

	// ===================
//	Simple Select:

//		Write a JPQL query to fetch all Book entities where the author is "Ashok".
//		Select with Like Operator:
	@Query("SELECT b FROM Book b where author = :author")
	List<Book> findByAuthorName(String author);

}
