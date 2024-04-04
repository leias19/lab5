package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "WeaponType")
@XmlEnum
public enum WeaponType {
    @XmlEnumValue("HAMMER")
    HAMMER,
    @XmlEnumValue("KNIFE")
    KNIFE,
    @XmlEnumValue("BAT")
    BAT;
}
