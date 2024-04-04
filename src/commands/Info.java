package commands;

import managers.CollectionManager;

public class Info implements Command{
    @Override
    public void execute(String[] arg) {
        System.out.println("Data type - " + CollectionManager.getMap().getClass().getName());
        System.out.println("Count of persons - " + CollectionManager.getMap().size());
        System.out.println("Init date - " + CollectionManager.getDate());
        System.out.println("команда выполнена :)");

    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

}
