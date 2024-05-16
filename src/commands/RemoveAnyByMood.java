package commands;


import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;

import java.util.Map;


public class RemoveAnyByMood implements Command {
    /**
     * Метод для выполнения команды remove_any_by_mood
     *
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg) {
        try {
            if (arg.length == 1) {
                System.out.println("введите настроение после 'remove_any_by_mood'");
            } else {
                int counter = 0;
                Mood moodToRemove = Mood.valueOf(arg[1].toUpperCase());
                for (Map.Entry<String, HumanBeing> humanBeing : CollectionManager.getMap().entrySet()) {
                    if (humanBeing.getValue().getMood() == moodToRemove) {
                        CollectionManager.remove(humanBeing.getKey());
                        System.out.println("удаление выполнено");
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    System.out.println("элемент с таким настроением не найден");
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





    /**
     * Метод для получения имени команды remove_any_by_mood
     *
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_any_by_mood";
    }

    /**
     * Метод для получения описания команды remove_any_by_mood
     *
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля mood которого эквивалентно заданному";
    }
}

