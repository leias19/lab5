package commands;

import managers.CommandManager;

import java.util.Map;

public class Help implements Command {
    @Override
    public void execute(String[] args)  {
        CommandManager commandManager = new CommandManager();
        Map<String, Command> commandList = commandManager.getCommandList();
        for (String name: commandList.keySet()){
            Command command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}