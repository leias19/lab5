package commands;

import managers.CollectionManager;
import errors.IncorrectInputException;
import data.HumanBeing;

import java.util.Scanner;
import java.util.TreeMap;

public class RemoveLowerKey implements Command {
    @Override
    public void execute(String[] arg) throws IncorrectInputException {
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый ключ: ");
        String[] humanBeingsKey = in.nextLine().split(" ");
        for (String key : map.keySet()) {
            if (key.compareTo(humanBeingsKey[0]) < 0){
                map.remove(key);
            }
        }
        CollectionManager.setMap(map);
        System.out.println("удаление выполнено");
    }

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых меньше, чем заданный";
    }
}
