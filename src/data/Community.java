package data;
import javax.xml.bind.annotation.*;
import java.util.Map;
import java.util.TreeMap;

@XmlType(name = "humans")
@XmlRootElement
public class Community {
    @XmlElementWrapper(name = "added-humans", nillable = true)
    @XmlElement
    public TreeMap<String, HumanBeing> humans = new TreeMap<>();

    public void addPersonToHuman(String key, HumanBeing humanBeing) {
        humans.put(key, humanBeing);
    }

    public TreeMap<String, HumanBeing> getHuman() {
        return humans;
    }
}
