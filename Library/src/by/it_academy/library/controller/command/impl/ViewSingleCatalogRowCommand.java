package by.it_academy.library.controller.command.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;
import by.it_academy.library.entity.Book;
import by.it_academy.library.entity.BookCatalog;
import by.it_academy.library.service.BookCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class ViewSingleCatalogRowCommand implements BasicCommand {
	private BookCatalogService catalogService;

	@Override
	public void performAction(Map<String, Object> map, Library library) {
		catalogService = new RegularServiceImpl();
		BookCatalog catalog = catalogService.listCatalog(library);

		System.out.print("Row number: ");
		Book row = catalog.getSingleRow(inputInt() - 1);
		System.out.println(row);
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

}
