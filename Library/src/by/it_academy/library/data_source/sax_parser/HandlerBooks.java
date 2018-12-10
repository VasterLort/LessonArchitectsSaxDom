package by.it_academy.library.data_source.sax_parser;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.it_academy.library.entity.Book;

import static by.it_academy.library.data_source.util.DataConstantStorage.*;

public class HandlerBooks extends DefaultHandler {
	private int id;
	private String element;
	private String title;
	private int size = 0;
	private List<Book> books = new ArrayList<Book>();

	@Override
	public void startDocument() throws SAXException {
		/*System.out.println("start parsing...");*/
	}

	@Override
	public void endDocument() throws SAXException {
		/*System.out.println("end parsing...");
		System.out.println();*/
	}

	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attribute) {
		element = qName;
		if (element.equals(COMMAND_BOOK_TAG)) {
			id = Integer.parseInt(attribute.getValue(0));
		}
		if(element.equals(COMMAND_AUTHOR_TAG)) {
			size++;
		}
	}

	@Override
	public void endElement(String namespace, String localName, String qName) throws SAXException {
		element = "";
		id = -1;
	}

	@Override
	public void characters(char[] ch, int start, int end) {
		if (element.equals(COMMAND_NAME_BOOK)) {
			title = new String(ch, start, end);
			Book book = new Book(id, title);
			books.add(book);
		}
	}

	public List<Book> getData() {
		return books; 
	}
	
	public int getSize() {
		return size;
	}
}
