package errors;

public class UnknownCommandException extends Exception{
    public UnknownCommandException(String commandName) {
        super("Неизвестная команда: " + commandName);
    }
}