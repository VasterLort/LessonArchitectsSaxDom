package by.it_academy.library.data_source.sax_parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

import static by.it_academy.library.data_source.util.DataConstantStorage.*;

public class SaxParser {
	public List<Author> startParserAuthors() {
		SAXParserFactory parserF = SAXParserFactory.newInstance();
		HandlerAuthors handler = new HandlerAuthors();
		try {
			SAXParser saxparser = parserF.newSAXParser();
			saxparser.parse(new File(COMMAND_AUTHOR_FILE), handler);
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Author> data = handler.getData();

		return data;
	}

	public List<Book[]> startParserBooks() {
		SAXParserFactory parserF = SAXParserFactory.newInstance();
		HandlerBooks handler = new HandlerBooks();
		try {
			SAXParser saxparser = parserF.newSAXParser();
			saxparser.parse(new File(COMMAND_BOOK_FILE), handler);
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Book> data = handler.getData();
		List<Book[]> listOfBooks = splitBooks(data);

		return listOfBooks;
	}

	private List<Book[]> splitBooks(List<Book> data) {
		List<Book[]> listOfBooks = new ArrayList<>();
		List<Book> newData = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			Book book = data.get(i);
			if (book.getId() == 1) {
				checkEmpty(newData, listOfBooks);
				newData = new ArrayList<>();
				newData.add(book);
			}
			if (book.getId() != 1) {
				newData.add(book);
			}
			checkLine(listOfBooks, data, newData, i);
		}
		return listOfBooks;
	}
	
	private void checkEmpty(List<Book> newData, List<Book[]> listOfBooks) {
		if (!newData.isEmpty()) {
			Book[] books = new Book[newData.size()];
			int j = 0;
			for (Book b : newData) {
				books[j] = b;
				j++;
			}
			listOfBooks.add(books);
		}
	}
	
	private void checkLine(List<Book[]> listOfBooks, List<Book> data, List<Book> newData, int i) {
		if (i == data.size() - 1) {
			Book[] books = new Book[newData.size()];
			int j = 0;
			for (Book b : newData) {
				books[j] = b;
				j++;
			}
			listOfBooks.add(books);
		}
	}
}
