package commands;

import managers.CollectionManager;
import errors.IncorrectInputException;
import data.HumanBeing;
import data.generators.HumanBeingGenerator;

public class Insert implements Command {
    /**
     *  Метод для выполнения команды insert
     * @param arg аргумент
     */

    @Override
    public void execute(String[] arg) {
        try {
            if (arg.length == 1){
                System.out.println("введите ключ после 'insert'");
            }else{
                HumanBeing humanBeing = HumanBeingGenerator.createHumanBeing(0);
                CollectionManager.add(arg[1], humanBeing);
            }
        } catch (IncorrectInputException e) {
            System.out.println("введите ключ после 'insert'");
        }

    }

    /**
     *  Метод для получения имени команды insert
     * @return имя
     */

    @Override
    public String getName() {
        return "insert";
    }

    /**
     *  Метод для получения описания команды insert
     * @return описание
     */

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}
