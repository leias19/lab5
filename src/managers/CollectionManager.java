package managers;

import data.comporators.HumanBeingComparator;
import data.generators.HumanBeingGenerator;
import errors.IncorrectInputException;
import errors.UnknownElementException;
import data.HumanBeing;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class CollectionManager {
    private static TreeMap<String, HumanBeing> map = new TreeMap<>();
    private static final LocalDate creationDate = LocalDate.now();

    /**
     * Метод для получения даты создания коллекции
     * @return дату создания
     */
    public static LocalDate getDate() {
        return creationDate;
    }

    /**
     * Метод для удаления элемента по ключу
     * @param key ключ
     * @throws UnknownElementException ошибка при отсутствии элемента
     */
    public static void remove(String key) throws UnknownElementException {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            throw new UnknownElementException();
        }
    }

    /**
     *  Метод для очистки коллекции
     */
    public static void clear() {
        map.clear();
    }
    public  static void show() {
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
            return;
        }
        for (String key : map.keySet()) {
            System.out.println(map.get(key).toString());
        }
    }
    /**
     * Метод для добавления в коллекцию
     * @param key ключ
     * @param humanBeing человек
     */
    public static void add(String key, HumanBeing humanBeing) {
        if (map == null) {
            map = new TreeMap<>();
        }
        map.put(key, humanBeing);
    }

    /**
     * Метод для получения коллекции
     * @return коллекцию
     */
    public static TreeMap<String, HumanBeing> getMap() {
        return map;
    }

    /**
     * Метод для установки коллекции
     * @param map коллекция
     */

    public static void setMap(TreeMap<String, HumanBeing> map) {
        CollectionManager.map = Objects.requireNonNullElseGet(map, TreeMap::new);
    }

    /**
     *  Метод для замены элемента коллекции по ключу
     * @param key ключ
     * @throws UnknownElementException ошибка при отсутствии элемента
     * @throws IncorrectInputException ошибка при некорректном вводе
     */

}