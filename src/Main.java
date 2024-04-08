import managers.Console;

public class Main {
    /**
     *  Метод для запуска
     * @param args имя файла
     */
    public static void main(String[] args) {
        Console console = new Console();
        System.out.println("Введите команду 'help', чтобы увидеть все доступные команды");
        String filename = args[0];
        console.setFilename(filename);
        console.start(System.in);
    }
}
