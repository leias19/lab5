package commands;

import data.WeaponType;
import errors.IncorrectInputException;
import errors.UnknownElementException;
import managers.CollectionManager;

public class CountLessThanWeaponType implements Command {
    @Override
    public void execute(String[] arg)  {
        try {
            WeaponType otherWeaponType = WeaponType.valueOf(arg[1]);
            int counter = 0;

            for (String key : CollectionManager.getMap().keySet()) {
                if (CollectionManager.getMap().get(key).getWeaponType().compareTo(otherWeaponType) > 0) {
                    counter++;
                }
            }
            System.out.println("количество элементов, значение поля weaponType которых меньше заданного = " + counter);
            System.out.println("команда выполнена :)");
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public String getName() {
        return "count_less_than_weapon_type weaponType";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля weaponType которых меньше заданного";
    }
}
