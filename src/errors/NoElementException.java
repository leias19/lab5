package errors;

public class NoElementException extends Throwable {
    /**
     *  Конструктор для исключения NoElementException
     * @param id неправильный индекс
     */
    public NoElementException(Integer id) {
        super("Нет элемента с данным индексом");
    }
}
