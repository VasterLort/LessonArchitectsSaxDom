package by.it_academy.library.service;

import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.entity.BookCatalog;

public interface AuthorCatalogService {
	AuthorCatalog authorCatalog(Library library);
	BookCatalog listBooksOfAuthor(Library library, int idAuthor);
}
