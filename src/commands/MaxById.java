package commands;

import managers.CollectionManager;
import data.HumanBeing;


import java.util.TreeMap;

public class MaxById implements Command {
    @Override
    public void execute(String[] args) throws Exception {
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

    @Override
    public String getName() {
        return "max_by_id";
    }

    @Override
    public String getDescription() {
        return "вывести любой объект из коллекции, значение поля id которого является максимальным";
    }
}
