package managers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String createDate) throws Exception {
        return LocalDate.parse(createDate);
    }

    public String marshal(LocalDate createDate) throws Exception {
        return createDate.toString();
    }
}
