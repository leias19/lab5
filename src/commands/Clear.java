package commands;

import managers.CollectionManager;
import errors.UnknownElementException;
import data.HumanBeing;


import java.util.TreeMap;

public class Clear implements Command{
    @Override
    public void execute(String[] arg) throws UnknownElementException {
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        map.clear();
        CollectionManager.setMap(map);
        System.out.println("коллекция очищена");

    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
