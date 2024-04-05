package commands;

import managers.CollectionManager;
import data.HumanBeing;


import java.util.TreeMap;

public class MaxById implements Command {
    /**
     *  Метод для выполнения команды max_by_id
     * @param args аргумент
     */
    @Override
    public void execute(String[] args) {
        HumanBeing humanBeing = null;
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (humanBeing == null) {
                humanBeing = map.get(key);
            } else if (humanBeing.compareTo(map.get(key)) < 0) {
                humanBeing = map.get(key);
            }
        }
        System.out.println(humanBeing);
        System.out.println("команда выполнена :)");
    }

    /**
     *  Метод для получения имени команды max_by_id
     * @return имя
     */

    @Override
    public String getName() {
        return "max_by_id";
    }

    /**
     *  Метод для получения описания команды max_by_id
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести любой объект из коллекции, значение поля id которого является максимальным";
    }
}
