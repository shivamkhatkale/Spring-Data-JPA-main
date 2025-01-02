package com.app.shivam.repository;

import com.app.shivam.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    /***
     * Output findBy<Varibale><condition>(DataType param);
     *
     * @param author
     * @return
     */

    // SQL : select * from BOOK where AUTHOR = ?
    // List<Book> findByauthor(String author);
    List<Book> findByAuthor(String author); // below both are same ( =? ) check raghu img

    List<Book> findByAuthorIs(String author);

    List<Book> findByAuthorEquals(String author);

    // SQL : select * from BOOK where bookType = ?
    // invalid : findBybtype, findbybooktype, findbookbytype
    // valid : findbybookType, findByBookType
    List<Book> findByBookType(String bookType);

    // SQL : select * from BOOK where bookCost = ?
//	List<Book> findByBookCost(Double bookCost);

    // findBy --> SELECT + where = !=, > < null, not null, and or...
    // SQL --> Select * from book where book_cost = ?
    List<Book> findByBookCostLessThanEqual(Double bookCost);

    // SQL : select * from book where book_id != ?
//	List<Book> findByBookIdNot(Double bookCost);

    // SQL : select * from book where cost = ?
//	List<Book> findByBookCostEqual(Double bookCost);

    // SQL : select * from book where cost >= ?
//	List<Book> findByBookCostGreaterThan(Double bookCost);

    // SQL : select * from book where Author is Null;
    List<Book> findByAuthorIsNull();

    // ******************* Like Operator ******************************

    // SQL : Select * from book where Author like '_____' // 5 character
    List<Book> findByAuthorLike(String author);

    // SQl : Select * from book where Author like '%input'
    List<Book> findByAuthorStartingWith(String Expression);

    // Order By
    // SQL : Select * from book where Author like ? order by bookname desc
    List<Book> findByAuthorLikeOrderByBookNameDesc(String expression);

    // SQl : Select * from book where Author like 'input%'
    List<Book> findByAuthorEndingWith(String author);

    // SQL : Select * from book where Author like '%input%'
    List<Book> findByBookIdBetween(Integer id1, Integer id2);

    // SQl : Select * from book where Author like '%input%'
    List<Book> findByAuthorContaining(String author);

    // --------------------------- AND / OR ---------------------------
    // SQL : Select * from book where bookId <= ? or bookType like ?
    List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer bookId, String bookType);

    // SQL : Select * from book where bookId != ? And bookType not like ?
    List<Book> findByBookIdNotAndBookTypeNotLike(Integer bookId, String bookType);

    // Not Recommended
    // SQL : select * from book where cost > ? and author is not null or btype like?
    // List<Book>
    // findByBookCostGreaterThanAndAuthorIsNotNullOrBookTypeNotLike(Double
    // cost,String btype);

    // --------------------------single row------------------
    Optional<Book> findByBookId(Integer bid);

    // Practice

    List<Book> findByBookNameLike(String bookName);

    // SELECT * FROM book WHERE book_type IS NOT NULL;

    List<Book> findByBookTypeIsNotNull();

    List<Book> findBybookTypeLike(String bookType);

    List<Book> findBybookCostIsLessThan(Integer bookCost);

    // Write a query to find all books where the author field is null.
    List<Book> findByauthorIsNull();

    // Create a method to find books where the bookId is not equal to 5.
    List<Book> findBybookIdNot(Integer bookId);


}
