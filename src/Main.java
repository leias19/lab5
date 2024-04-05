
import errors.NoElementException;
import managers.Console;

public class Main {
    /**
     *  Метод для запуска
     * @param args имя файла
     * @throws NoElementException ошибка при отсутствии элемента
     */
    public static void main(String[] args) throws NoElementException {
        Console console = new Console();
        System.out.println("Введите команду 'help', чтобы увидеть все доступные команды");
        String filename = args[0];
        console.setFilename(filename);
        console.start(System.in);
    }
}
