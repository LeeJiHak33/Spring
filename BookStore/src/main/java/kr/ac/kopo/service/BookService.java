package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.pager.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(int bookid);

	void update(Book item);

	void delete(int bookid);

	void dummy();

	void init();

}
