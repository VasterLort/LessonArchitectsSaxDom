package by.it_academy.library.dao;

import java.util.List;

import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

public interface AuthorDao {
	List<Author> getAuthors(Library library);
	List<Book> searchAuthor(Library library, int idAuthor);
}