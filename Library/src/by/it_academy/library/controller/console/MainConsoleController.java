package by.it_academy.library.controller.console;

import static by.it_academy.library.controller.console.view.SimpleConsoleView.*;
import static by.it_academy.library.controller.command.CommandManager.*;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.data_source.data.Library;

import static by.it_academy.library.controller.util.ControllerConstantStorage.*;

public class MainConsoleController {

	public static void main(String[] args) {
		Library library = new Library();

		while(true){
			showBasicMenu();
			
			Map<String, Object> userData = readUserInput();
			Object userAction = userData.get(COMMAND_USER_ACTION);
			BasicCommand command = defineCommand(convertString(userAction));
			command.performAction(userData, library);
		}
	}

	private static String convertString(Object obj){
		return (String) obj;
	}
}
