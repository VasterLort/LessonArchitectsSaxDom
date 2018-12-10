package by.it_academy.library.dao.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.it_academy.library.dao.AuthorDao;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

public class AuthorDaoCollectionImpl implements AuthorDao {

	@Override
	public List<Author> getAuthors(Library library) {
		Map<Author, Book[]> l = library.getLibrary();
		List<Author> authors = new ArrayList<>();

		for (Entry<Author, Book[]> entry : l.entrySet()) {
			authors.add(entry.getKey());
		}

		return authors;
	}

	@Override
	public List<Book> searchAuthor(Library library, int idAuthor) {
		Map<Author, Book[]> l = library.getLibrary();
		List<Book> books = new ArrayList<>();

		for (Entry<Author, Book[]> entry : l.entrySet()) {
			if (idAuthor == entry.getKey().getId()) {
				Book[] book = entry.getValue();
				for (int i = 0; i < book.length; i++) {
					books.add(book[i]);
				}
				break;
			}
		}

		return books;
	}
}
