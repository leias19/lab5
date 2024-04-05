package commands;

import managers.CollectionManager;
import errors.NoElementException;
import data.HumanBeing;
import data.generators.HumanBeingGenerator;


public class UpdateId implements Command {
    /**
     *  Метод для выполнения команды update_id
     * @param arg аргумент
     * @throws NoElementException ошибка при отсутствии элемента
     */
    @Override
    public void execute(String[] arg) throws NoElementException {
        try {
            if (arg.length == 1) {
                System.out.println("введите id после 'update_id'");
            }else{
                int id = Integer.parseInt(arg[1]);
                for (String key : CollectionManager.getMap().keySet()) {
                    if (CollectionManager.getMap().get(key).getId() == id) {
                        HumanBeing humanBeing = HumanBeingGenerator.createHumanBeing(id);
                        CollectionManager.remove(key);
                        CollectionManager.add(key, humanBeing);

                        System.out.println("элемент был обновлен");
                    }else{
                        System.out.println("элемент с таким id отсутствует");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Метод для получения имени команды update_id
     * @return имя
     */

    @Override
    public String getName() {
        return "update_id";
    }

    /**
     *  Метод для получения описания команды update_id
     * @return описание
     */

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
