package commands;

import managers.CollectionManager;
import data.HumanBeing;
import java.util.Scanner;
import java.util.TreeMap;

public class RemoveLowerKey implements Command {
    /**
     *  Метод для выполнения команды remove_lower_key
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg)  {
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        TreeMap<String, HumanBeing> newMap = new TreeMap<>();
        if (arg.length == 1){
            System.out.println("введите ключ после 'remove_greater_key'");
        }else{
            for (String keys : map.keySet()) {
                if (Integer.parseInt(keys) > Integer.parseInt(arg[1])) {
                    newMap.put(keys, map.get(keys));
                }
            }
            CollectionManager.setMap(newMap);
            System.out.println("удаление выполнено");
        }

    }

    /**
     *  Метод для получения имени команды remove_lower_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    /**
     *  Метод для получения описания команды remove_lower_key
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых меньше, чем заданный";
    }
}
