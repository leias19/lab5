package errors;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String data){

        super("Неправильный аргумент ввода: " + data);
    }
}