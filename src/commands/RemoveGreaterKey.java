package commands;

import managers.CollectionManager;
import data.HumanBeing;

import java.util.Scanner;
import java.util.TreeMap;

public class RemoveGreaterKey implements Command {
    /**
     *  Метод для выполнения команды remove_greater_key
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg)  {
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый ключ: ");
        String[] humanBeingsKey = in.nextLine().split(" ");
        for (String key : map.keySet()) {
            if (key.compareTo(humanBeingsKey[0]) > 0){
                map.remove(key);
            }
        }
        CollectionManager.setMap(map);
        System.out.println("удаление выполнено");
    }

    /**
     *  Метод для получения имени команды remove_greater_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    /**
     *  Метод для получения описания команды remove_greater_key
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых превышает заданный";
    }
}
