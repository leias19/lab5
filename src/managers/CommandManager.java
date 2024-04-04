package managers;

import commands.*;
import errors.NoElementException;
import errors.UnknownCommandException;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static Map<String, Command> commandList;

    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("insert", new Insert());
        commandList.put("update_id", new UpdateId());
        commandList.put("remove_key", new RemoveKey());
        commandList.put("clear", new Clear());
        commandList.put("save", new Save());
        commandList.put("execute_script", new ExecuteScript());
        commandList.put("exit", new Exit());
        commandList.put("replace_if_greater", new ReplaceIfGreater());
        commandList.put("remove_greater_key", new RemoveGreaterKey());
        commandList.put("remove_lower_key", new RemoveLowerKey());
        commandList.put("remove_any_by_mood", new RemoveAnyByMood());
        commandList.put("max_by_id", new MaxById());
        commandList.put("count_less_than_weapon_type", new CountLessThanWeaponType());
    }

    public static void startExecuting(String line) throws Exception, NoElementException {
        String commandName = line.split(" ")[0];
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
        }
        Command command = commandList.get(commandName);
        command.execute(line.split(" "));

    }
    public Map<String, Command> getCommandList() {
        return commandList;
    }
}
