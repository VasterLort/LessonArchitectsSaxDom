package by.it_academy.library.controller.command.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;
import by.it_academy.library.entity.BookCatalog;
import by.it_academy.library.service.AuthorCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class FindBooksByAuthor implements BasicCommand{
	private AuthorCatalogService authorCatalogService;
	
	@Override
	public void performAction(Map<String, Object> map, Library library) {
		authorCatalogService = new RegularServiceImpl();
		BookCatalog catalog = authorCatalogService.listBooksOfAuthor(library, authors(library));
		System.out.println();
		System.out.println(catalog);
	}
	
	private static int inputInt() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.parseInt(read.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return num;
	}
	
	private static int authors(Library library) {
		Map<Author, Book[]> l = library.getLibrary();

		for (Entry<Author, Book[]> entry : l.entrySet()) {
			System.out.print(entry.getKey().toString());
		}
		
		return inputInt();
	}
}
