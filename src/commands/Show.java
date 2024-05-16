package commands;

import managers.CollectionManager;
import data.HumanBeing;
import java.util.TreeMap;

public class Show implements Command {
    /**
     *  Метод для выполнения команды show
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg)  {
        CollectionManager.show();
    }

    /**
     *  Метод для получения имени команды show
     * @return имя
     */

    @Override
    public String getName() {
        return "show";
    }

    /**
     *  Метод для получения описания команды show
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
