package by.it_academy.library.data_source.sax_parser;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.it_academy.library.entity.Author;

import static by.it_academy.library.data_source.util.DataConstantStorage.*;

public class HandlerAuthors extends DefaultHandler {
	private int id;
	private String element;
	private String name;
	private String surname;
	private int age;
	private List<Author> authors = new ArrayList<Author>();

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
		if (element.equals(COMMAND_AUTHOR_TAG)) {
			id = Integer.parseInt(attribute.getValue(0));
		}
	}

	@Override
	public void endElement(String namespace, String localName, String qName) throws SAXException {
		element = "";
	}

	@Override
	public void characters(char[] ch, int start, int end) {
		if (element.equals(COMMAND_NAME_AUTHOR)) {
			name = new String(ch, start, end);
		}
		if (element.equals(COMMAND_SURNAME_AUTHOR)) {
			surname = new String(ch, start, end);
		}
		if (element.equals(COMMAND_AGE_AUTHOR)) {
			String num = new String(ch, start, end);
			age = Integer.parseInt(num);
			Author author = new Author(id, name, surname, age);
			authors.add(author);
			id = -1;
		}
	}

	public List<Author> getData() {
		return authors;
	}
}
