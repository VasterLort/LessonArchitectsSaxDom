package by.it_academy.library.dao;

import java.util.List;

import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Book;

public interface BookDao {
	List<Book> getBooks(Library library);
	void addBooks(Library library);
}
