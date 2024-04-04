package commands;


import data.HumanBeing;
import data.Mood;
import errors.NoElementException;
import errors.UnknownElementException;
import managers.CollectionManager;


public class RemoveAnyByMood implements Command {
    @Override
    public void execute(String[] arg) throws NoElementException {
        try {
            Mood moodToRemove = Mood.valueOf(arg[1]);
            for (String key : CollectionManager.getMap().keySet()) {
                if (CollectionManager.getMap().get(key).getMood() == moodToRemove) {
                    HumanBeing humanBeing = new HumanBeing();
                    CollectionManager.remove(key);
                    CollectionManager.add(key, humanBeing);
                    System.out.println("удаление выполнено");
                }
                else {
                    throw new UnknownElementException();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "remove_any_by_mood";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля mood которого эквивалентно заданному";
    }
}
