package commands;

import managers.CollectionManager;
import errors.IncorrectInputException;
import errors.UnknownElementException;
import data.HumanBeing;
import data.comporators.HumanBeingComparator;
import data.generators.HumanBeingGenerator;


import java.util.TreeMap;


public class ReplaceIfGreater implements Command {

    @Override
    public void execute(String[] args) throws IncorrectInputException, UnknownElementException {
        try {
            if (args.length == 1) {
                System.out.println("введите ключ после 'replace_if_greater'");
            }else{
                String key = args[1];
                TreeMap<String, HumanBeing> map = CollectionManager.getMap();
                HumanBeingComparator h1 = new HumanBeingComparator();
                if (map.containsKey(key)) {
                    HumanBeing humanBeing = HumanBeingGenerator.createHumanBeing(0);
                    if (h1.compare(humanBeing, map.get(key)) > 0) {
                        CollectionManager.remove(key);
                        CollectionManager.add(key, humanBeing);
                    }
                }else{
                    System.out.println("элемент с таким ключом отсутствует");
                }
            }
            System.out.println("команда выполнена :)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "заменить значение по ключу, если новое значение больше старого";
    }
}
