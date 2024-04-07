package commands;
import errors.*;

import java.io.FileNotFoundException;

public interface Command {
    /**
     *  Метод для выполнения команды
     * @param arg аргумент
     * @throws FileNotFoundException Исключение при некорректном вводе
     * @throws UnknownElementException Исключение при некорректном вводе
     */
    void execute(String[] arg) throws FileNotFoundException, UnknownElementException, IncorrectInputException;

    /**
     *  Метод для получения имени команды
     * @return имя
     */
    String getName();

    /**
     *  Метод для получения описания
     * @return описание
     */
    String getDescription();
}