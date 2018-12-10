package by.it_academy.library.service;

import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.entity.BookCatalog;

public interface BookCatalogService {
	BookCatalog listCatalog(Library library);
	void addBookToCatalog(Library library);
}
