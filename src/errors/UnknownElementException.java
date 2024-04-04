package errors;

public class UnknownElementException extends Exception {
    public UnknownElementException() {
        super("Неизвестный элемент");
    }

    public UnknownElementException(String key) {
        super("неизвестный элемент с ключом " + key);
    }
}
