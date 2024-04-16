package managers;

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

    public static void removeIf(HumanBeing humanBeing) {
        for (String key : map.keySet()) {
            if (map.get(key) == humanBeing) {
                map.remove(key);
            }
        }
    }

    public static void insertInScript(String[] args) throws Exception {
        if (args.length >= 14) {
            ArrayList<String> data = new ArrayList<>();
            for (int i = 1 ;i<args.length;i++){
                data.add(args[i]);
            }
            HumanBeing humanBeing = new HumanBeing(data.toArray(new String[0]));
            CollectionManager.add(args[1], humanBeing);
            System.out.println("элемент был добавлен в коллекцию");
        } else {
            System.out.println("недостаточно аргументов для добавления элемента в коллекцию");
        }
    }
}