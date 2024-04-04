package commands;

import managers.CollectionManager;
import data.HumanBeing;

import java.util.TreeMap;

public class Show implements Command {
    @Override
    public void execute(String[] arg)  {
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
            return;
        }
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
        System.out.println("команда выполнена :)");

    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
