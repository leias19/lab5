package commands;

import managers.CollectionManager;
import data.HumanBeing;


import java.util.TreeMap;

public class Clear implements Command{
    /**
     *  Метод для выполнения команды clear
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg)  {
        CollectionManager.clear();
        System.out.println("коллекция очищена");
    }

    /**
     *  Метод для получения имени команды clear
     * @return имя
     */

    @Override
    public String getName() {
        return "clear";
    }

    /**
     *  Метод для получения описания команды clear
     * @return описание
     */

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
