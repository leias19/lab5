package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


@XmlEnum(String.class)
/**
 *  Перечисление состояний чувства
 */
public enum Mood {
    @XmlEnumValue("SADNESS")
    SADNESS,
    @XmlEnumValue("SORROW")
    SORROW,
    @XmlEnumValue("LONGING")
    LONGING,
    @XmlEnumValue("GLOOM")
    GLOOM,
    @XmlEnumValue("CALM")
    CALM;
}
