package by.it_academy.library.data_source.dom_parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

import static by.it_academy.library.data_source.util.DataConstantStorage.*;

public class DomParser{
	private int idAuthor = 0;
	private String name = "";
	private String surname = "";
	private int age = 0;
	private int idBook = 0;
	private String title = "";
	
	public List<Author> AuthorsParser() throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(new File(COMMAND_AUTHOR_FILE));
		NodeList nodeList = doc.getElementsByTagName(COMMAND_AUTHOR_TAG);
		List<Author> list = fillListAuthors(nodeList);
		
		return list;
	}
	
	public List<Book[]> BooksParser() throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(new File(COMMAND_BOOK_FILE));
		NodeList nodeList = doc.getElementsByTagName(COMMAND_BOOK_TAG);
		List<Book> list = fillListBooks(nodeList);
		List<Book[]> listOfBooks = splitBooks(list);
		
		return listOfBooks;
	}
	
	private List<Author> fillListAuthors(NodeList nodeList) {
		List<Author> list = new ArrayList<Author>();
		for(int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element)nodeList.item(i);
			idAuthor = Integer.parseInt(element.getAttribute(COMMAND_ID_AUTHOR));
			name = element.getElementsByTagName(COMMAND_NAME_AUTHOR).item(0).getChildNodes().item(0).getNodeValue();
			surname = element.getElementsByTagName(COMMAND_SURNAME_AUTHOR).item(0).getChildNodes().item(0).getNodeValue();
			age = Integer.parseInt(element.getElementsByTagName(COMMAND_AGE_AUTHOR).item(0).getChildNodes().item(0).getNodeValue());
			Author author = new Author(idAuthor, name, surname, age);
	        list.add(author);
		}
		return list;
	}
	
	private List<Book> fillListBooks(NodeList nodeList) {
		List<Book> list = new ArrayList<Book>();
		for(int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			idBook = Integer.parseInt(element.getAttribute(COMMAND_ID_BOOK));
			title = element.getElementsByTagName(COMMAND_NAME_BOOK).item(0).getChildNodes().item(0).getNodeValue();
	        Book book = new Book(idBook, title);
	        list.add(book);
		}
		return list;
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
