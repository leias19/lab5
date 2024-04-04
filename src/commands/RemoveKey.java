package commands;

import managers.CollectionManager;
import errors.UnknownElementException;

public class RemoveKey implements Command {
    @Override
    public void execute(String[] arg) throws UnknownElementException {
        if (arg.length == 1) {
            System.out.println("введите ключ после 'remove_key'");
        }else{
            CollectionManager.remove(arg[1]);
            System.out.println("удаление выполнено");
        }
    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }
}
