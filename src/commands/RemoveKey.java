package commands;

import managers.CollectionManager;
import errors.UnknownElementException;

public class RemoveKey implements Command {
    /**
     *  Метод для выполнения команды remove_key
     * @param arg аргумент
     * @throws UnknownElementException ошибка при отсутствии элемента
     */
    @Override
    public void execute(String[] arg) throws UnknownElementException {
        if (arg.length == 1) {
            System.out.println("введите ключ после 'remove_key'");
        }else{
            CollectionManager.remove(arg[1]);
            System.out.println("удаление выполнено");
        }
    }

    /**
     *  Метод для получения имени команды remove_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_key";
    }

    /**
     *  Метод для получения описания команды remove_key
     * @return  описание
     */

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }
}
