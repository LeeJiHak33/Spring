package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.pager.Pager;

public interface BookDao {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(int bookid);

	void update(Book item);

	void delete(int bookid);

	int total(Pager pager);

}
