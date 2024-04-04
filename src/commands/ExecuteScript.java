package commands;

import errors.NoElementException;
import managers.CommandManager;

import java.io.*;
import java.util.Scanner;

public class ExecuteScript implements Command {
    @Override
    public void execute(String[] args) throws Exception, NoElementException {
        String file_path = args[1];
        Scanner scanner = new Scanner(new FileReader(file_path));
        try{
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                CommandManager.startExecuting(line);
            }
            System.out.println("команда выполнена :)");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "execute_script file_name";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
