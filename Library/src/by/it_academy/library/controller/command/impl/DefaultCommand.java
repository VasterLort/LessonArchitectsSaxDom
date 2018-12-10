package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;

public class DefaultCommand implements BasicCommand{

	@Override
	public void performAction(Map<String, Object> map, Library library) {
		System.out.println("Incorrect user input");
	}

}
