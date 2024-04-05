package data;

import javax.xml.bind.annotation.XmlElement;

public class Car {
    private String name;
    private boolean cool;

    /**
     *  Пустой конструктор для машины
     */
    public Car(){}

    /**
     *  Конструктор для машины
     * @param name имя
     * @param cool состояние
     */
    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }

    /**
     *  Метод для получения имени
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     *  Метод для установки имени
     * @param name name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *  Метод для получения состояния
     * @return cool
     */

    public boolean getCool(){
        return cool;
    }

    /**
     *  Метод для установки состояния
     * @param cool cool
     */

    public void setCool(boolean cool){
        this.cool = cool;
    }
}