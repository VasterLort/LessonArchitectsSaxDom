package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.service.AuthorCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class ViewAuthorsCatalogCommand implements BasicCommand{
	private AuthorCatalogService authorCatalogService;
	
	@Override
	public void performAction(Map<String, Object> map, Library library) {
		authorCatalogService = new RegularServiceImpl();
		AuthorCatalog catalog = authorCatalogService.authorCatalog(library);
		System.out.println(catalog);
	}

}
