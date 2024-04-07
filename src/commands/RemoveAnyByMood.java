package commands;


import data.HumanBeing;
import data.Mood;
import errors.UnknownElementException;
import managers.CollectionManager;


public class RemoveAnyByMood implements Command {
    /**
     *  Метод для выполнения команды remove_any_by_mood
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg)  {
        try {
            Mood moodToRemove = Mood.valueOf(arg[1].toUpperCase());
            for (String key : CollectionManager.getMap().keySet()) {
                if (CollectionManager.getMap().get(key).getMood() == moodToRemove) {
                    CollectionManager.remove(key);
                    System.out.println("удаление выполнено");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Метод для получения имени команды remove_any_by_mood
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_any_by_mood";
    }

    /**
     *  Метод для получения описания команды remove_any_by_mood
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля mood которого эквивалентно заданному";
    }
}
