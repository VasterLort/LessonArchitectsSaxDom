package by.it_academy.library.data_source.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.it_academy.library.data_source.dom_parser.DomParser;
import by.it_academy.library.data_source.sax_parser.SaxParser;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

public class Library {
	private Map<Author, Book[]> library;
	private int size = 0;

	public Library() {
		super();
		this.library = selectInitializationDate();
	}

	@Override
	public String toString() {
		return "Library [authors = " + library + ", getClass() = " + getClass() + ", hashCode() = " + hashCode()
				+ ", toString() = " + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		return result;
	}

	public Map<Author, Book[]> getLibrary() {
		return library;
	}

	private Map<Author, Book[]> selectInitializationDate() {
		Map<Author, Book[]> map = new HashMap<>();
		int s = menuSelectInitializationDate();
		if (s == 1)
			map = saxInitializationDate();
		else if (s == 2) {
				try {
					map = domInitializationDate();
				} catch (SAXException | IOException | ParserConfigurationException e) {
					e.printStackTrace();
				}
			}
		
		return map;
	}

	private int menuSelectInitializationDate() {
		System.out.println("1 - Получение данных с помощью SAX");
		System.out.println("2 - Получение данных с помощью DOM");
		int s = Integer.parseInt(input());
		return s;
	}

	private Map<Author, Book[]> saxInitializationDate() {
		SaxParser parser = new SaxParser();
		List<Author> authors = parser.startParserAuthors();
		List<Book[]> books = parser.startParserBooks();
		Map<Author, Book[]> map = new HashMap<>();

		for (int i = 0; i < authors.size(); i++) {
			map.put(authors.get(i), books.get(i));
		}
		size = map.size();

		return map;
	}

	private Map<Author, Book[]> domInitializationDate() throws SAXException, IOException, ParserConfigurationException{
		DomParser parser = new DomParser();
		List<Author> authors = parser.AuthorsParser();
		List<Book[]> books = parser.BooksParser();
		Map<Author, Book[]> map = new HashMap<>();

		for (int i = 0; i < authors.size(); i++) {
			map.put(authors.get(i), books.get(i));
		}
		size = map.size();

		return map;
	}

	public void addBooks() {
		size++;
		System.out.print("Имя автора: ");
		String name = input();
		System.out.print("Фамилия автора: ");
		String surname = input();
		System.out.print("Возраст автора: ");
		int age = Integer.parseInt(input());
		Author author = new Author(size, name, surname, age);
		Book[] b = listOfBook();
		library.put(author, b);
	}

	private String input() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private Book[] listOfBook() {
		System.out.print("Ведите количество книг данного автора: ");
		Book[] b = new Book[Integer.parseInt(input())];
		for (int i = 0; i < b.length; i++) {
			System.out.print("Ведите название книги: ");
			int num = i + 1;
			b[i] = new Book(num, input());
		}
		return b;
	}
}
