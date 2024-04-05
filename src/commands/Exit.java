package commands;

public class Exit implements Command{
    /**
     *  Метод для выполнения команды exit
     * @param arg аргумент
     */
    @Override
    public void execute(String[] arg) {
        System.out.println("пока пока");
        System.exit(1);
    }

    /**
     *  Метод для получения имени команды exit
     * @return  имя
     */

    @Override
    public String getName() {
        return "exit";
    }

    /**
     *  Метод для получения описания команды exit
     * @return  описание
     */

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
