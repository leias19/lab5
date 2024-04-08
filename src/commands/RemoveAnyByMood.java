package commands;


import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;


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
                for (HumanBeing humanBeing : CollectionManager.getMap().values()) {
                    if (humanBeing.getMood() == moodToRemove) {
                        CollectionManager.removeIf(humanBeing);
                        System.out.println("удаление выполнено");
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    System.out.println("элемент с таким настроением не найден");
                }

            }
        } catch (Exception ignored) {}
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

