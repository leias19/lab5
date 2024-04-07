package data;

import javax.xml.bind.annotation.*;
import java.util.TreeMap;

@XmlType(name = "humans")
@XmlRootElement
public class Community {
    @XmlElementWrapper(name = "added-humans", nillable = true)
    @XmlElement
    public TreeMap<String, HumanBeing> humans = new TreeMap<>();

    /**
     * Метод для добавления элемента
     * @param key ключ
     * @param humanBeing человек
     */
    public void addPersonToHuman(String key, HumanBeing humanBeing) {
        humans.put(key, humanBeing);
    }

    /**
     *  Метод для получения элемента
     * @return Коллекцию
     */

    public TreeMap<String, HumanBeing> getHuman() {
        return humans;
    }
}
