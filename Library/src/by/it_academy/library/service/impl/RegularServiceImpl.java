package by.it_academy.library.service.impl;

import java.util.Date;
import java.util.List;

import by.it_academy.library.dao.AuthorDao;
import by.it_academy.library.dao.BookDao;
import by.it_academy.library.dao.collection.AuthorDaoCollectionImpl;
import by.it_academy.library.dao.collection.BookDaoCollectionImpl;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;
import by.it_academy.library.entity.BookCatalog;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.service.AuthorCatalogService;
import by.it_academy.library.service.BookCatalogService;

public class RegularServiceImpl implements BookCatalogService, AuthorCatalogService{
	private BookDao bookDao;
	private AuthorDao authorDao;
	private final static String PERSONAL_NAME = "Liudvik Arestarhovich";
	
	@Override
	public BookCatalog listCatalog(Library library) {
		BookCatalog catalog = new BookCatalog();
		catalog.setResposniblePerson(PERSONAL_NAME);
		catalog.setCreationDate(new Date());
		
		bookDao = new BookDaoCollectionImpl();
		List<Book> books = bookDao.getBooks(library);
		
		catalog.setBooks(books);
		
		return catalog;
	}
	
	@Override
	public BookCatalog listBooksOfAuthor(Library library, int idAuthor) {
		BookCatalog catalog = new BookCatalog();
		catalog.setResposniblePerson(PERSONAL_NAME);
		catalog.setCreationDate(new Date());
		
		authorDao = new AuthorDaoCollectionImpl();
		List<Book> books = authorDao.searchAuthor(library, idAuthor);
		
		catalog.setBooks(books);
		
		return catalog;
	}
	
	@Override
	public AuthorCatalog authorCatalog(Library library) {
		AuthorCatalog catalog = new AuthorCatalog();
		catalog.setResposniblePerson(PERSONAL_NAME);
		catalog.setCreationDate(new Date());
		
		authorDao = new AuthorDaoCollectionImpl();
		List<Author> authors = authorDao.getAuthors(library);
		
		catalog.setAuthor(authors);
		
		return catalog;
	}

	@Override
	public void addBookToCatalog(Library library) {
		bookDao = new BookDaoCollectionImpl();
		bookDao.addBooks(library);
	}
}
