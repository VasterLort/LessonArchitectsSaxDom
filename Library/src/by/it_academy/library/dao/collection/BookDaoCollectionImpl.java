package by.it_academy.library.dao.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.it_academy.library.dao.BookDao;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

public class BookDaoCollectionImpl implements BookDao {

	@Override
	public List<Book> getBooks(Library library) {
		Map<Author, Book[]> l = library.getLibrary();
		List<Book> books = new ArrayList<>();

		for (Entry<Author, Book[]> entry : l.entrySet()) {
			Book[] book = entry.getValue();
			for (int i = 0; i < book.length; i++)
				books.add(book[i]);
		}

		return books;
	}

	@Override
	public void addBooks(Library library) {
		library.addBooks();
	}
}
