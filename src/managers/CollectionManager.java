package managers;

import errors.UnknownElementException;
import data.HumanBeing;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class CollectionManager {
    private static TreeMap<String, HumanBeing> map = new TreeMap<>();
    private static final LocalDate creationDate = LocalDate.now();
    public static LocalDate getDate() {
        return creationDate;
    }

    public static void remove(String key) throws UnknownElementException {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            throw new UnknownElementException();
        }
    }
    public static void add(String key, HumanBeing humanBeing) {
        if (map == null) {
            map = new TreeMap<>();
        }
        map.put(key, humanBeing);
    }

    public static TreeMap<String, HumanBeing> getMap() {
        return map;
    }

    public static void setMap(TreeMap<String, HumanBeing> map) {
        CollectionManager.map = Objects.requireNonNullElseGet(map, TreeMap::new);
    }
    public void addToCollection(Map<String, HumanBeing> collection) {
        map.putAll(collection);
    }
}
