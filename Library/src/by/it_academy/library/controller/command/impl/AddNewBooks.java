package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.service.BookCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class AddNewBooks implements BasicCommand{
private BookCatalogService catalogService;
	
	@Override
	public void performAction(Map<String, Object> map, Library library) {
		catalogService = new RegularServiceImpl();
		catalogService.addBookToCatalog(library);
	}

}
