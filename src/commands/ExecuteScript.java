package commands;

import errors.IncorrectInputException;
import errors.UnknownCommandException;
import errors.UnknownElementException;
import managers.CommandManager;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExecuteScript implements Command {
    public static Set<String> scripts = new HashSet<>();

    /**
     *  Метод для выполнения команды execute_script
     * @param args аргумент
     * @throws FileNotFoundException Исключение при некорректном вводе
     */
    @Override
    public void execute(String[] args) throws FileNotFoundException {
        String file_path = args[1];
        Scanner scanner = new Scanner(new FileReader(file_path));
        try{
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                CommandManager.startExecuting(line, scripts);
            }
            System.out.println("команда выполнена :)");
        } catch (FileNotFoundException e) {
            System.out.println("нет такого файла");
        } catch (UnknownElementException e) {
            System.err.println("неизвестный элемент");
        } catch (UnknownCommandException | IncorrectInputException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *  Метод для получения имени команды execute_script
     * @return имя
     */

    @Override
    public String getName() {
        return "execute_script file_name";
    }

    /**
     *  Метод для получения описания команды execute_script
     * @return описание
     */

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
