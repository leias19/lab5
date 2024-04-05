package commands;

import managers.CommandManager;

import java.util.Map;

public class Help implements Command {
    /**
     *  Метод для выполнения команды help
     * @param args аргумент
     */
    @Override
    public void execute(String[] args)  {
        CommandManager commandManager = new CommandManager();
        Map<String, Command> commandList = commandManager.getCommandList();
        for (String name: commandList.keySet()){
            Command command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    /**
     *  Метод для получения имени команды help
     * @return имя
     */

    @Override
    public String getName() {
        return "help";
    }

    /**
     *  Метод для получения описания команды help
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}