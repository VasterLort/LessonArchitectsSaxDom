package by.it_academy.library.controller.command;

import java.util.Map;

import by.it_academy.library.data_source.data.Library;

public interface BasicCommand {
	void performAction(Map<String, Object> map, Library library);
}
