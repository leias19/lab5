package data;

import javax.xml.bind.annotation.XmlElement;

public class Car {
    private String name;
    private boolean cool;

    public Car(){}

    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public boolean getCool(){
        return cool;
    }

    public void setCool(boolean cool){
        this.cool = cool;
    }
}