package commands;

import managers.CollectionManager;
import errors.IncorrectInputException;
import data.HumanBeing;
import data.generators.HumanBeingGenerator;

public class Insert implements Command {

    @Override
    public void execute(String[] arg) throws Exception {
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

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}
