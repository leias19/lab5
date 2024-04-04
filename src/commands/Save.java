package commands;



import data.HumanBeing;
import managers.CollectionManager;
import managers.FileManager;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Save implements Command {
    @Override
    public void execute(String[] arg)  {
        Map<String, HumanBeing> map = CollectionManager.getMap();
        if (map.isEmpty()) {
            System.err.println("Похоже у вас в коллекции ничего нет, если вы сохраните пустую коллекцию, то ваше прошлое сохранение уничтожится! Точно ли вы хотите этого?");
            System.out.println("y/n");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    System.out.println("Сохранение перезаписано");
                    break;
                } else if (answer.equals("n")) {
                    map.putAll(Objects.requireNonNull(FileManager.readFile(arg[1])).getHuman());
                    System.out.println("Сохранение восстановлено");
                    return;
                } else {
                    System.err.println("Нет такого варианта ответа :(");
                }
            }
        } else {
            FileManager.writeFile(map);
        }
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}
