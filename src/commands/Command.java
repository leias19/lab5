package commands;
import errors.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    /**
     *  Метод для выполнения команд
     * @param arg аргумент
     * @throws NoElementException ошибка при отсутствии элемента
     * @throws Exception ошибка при выполнении
     */
    public void execute(String[] arg) throws NoElementException, FileNotFoundException, UnknownElementException;

    /**
     *  Метод для получения имени команды
     * @return имя
     */
    public String getName();

    /**
     *  Метод для получения описания
     * @return описание
     */
    public String getDescription();
}