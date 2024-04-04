package data;


import managers.LocalDateAdapter;
import managers.Validator;
import data.generators.IdGenerator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


public class HumanBeing implements Comparable<HumanBeing>{
    private int id;
    private String name;
    private Coordinates coordinates;
    @XmlTransient
    private java.time.LocalDate creationDate;
    private Boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private String soundtrackName;
    private WeaponType weaponType;
    private Mood mood;
    private Car car;


    public HumanBeing(String[] data) throws Exception{
        Validator.moreThanZero(data[1]);
        Validator.inputIsNotEmpty(data[2], "name");
        Validator.coordinateXIsRight(data[3]);
        Validator.coordinateYIsRight(data[4]);
        Validator.booleanNotNull(data[5], "realHero");
        Validator.booleanIsBoolean(data[6], "hasToothpick");
        Validator.doubleIsDouble(data[7], "impactSpeed");
        Validator.inputIsNotEmpty(data[8], "soundtrackName");
        Validator.weaponTypeIsRight(data[9]);
        Validator.moodIsRight(data[10]);
        Validator.inputIsNotEmpty(data[11], "car");
        Validator.booleanIsBoolean(data[12], "car");

        this.id = Integer.parseInt(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Integer.parseInt(data[3]), Long.parseLong(data[4]));
        this.creationDate = LocalDate.now();
        this.realHero = Boolean.parseBoolean(data[5]);
        this.hasToothpick = Boolean.parseBoolean(data[6]);
        this.impactSpeed = Double.parseDouble(data[7]);
        this.soundtrackName = data[8];
        this.weaponType = WeaponType.valueOf(data[9]);
        this.mood = Mood.valueOf(data[10]);
        this.car = new Car(data[11], Boolean.parseBoolean(data[12]));

    }

    public HumanBeing(){
        this.id = IdGenerator.generateid();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.realHero = false;
        this.hasToothpick = false;
        this.impactSpeed = 0;
        this.soundtrackName = null;
        this.weaponType = null;
        this.mood = null;
        this.car = null;
    }

    public HumanBeing(int id){
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.realHero = false;
        this.hasToothpick = false;
        this.impactSpeed = 0;
        this.soundtrackName = null;
        this.weaponType = null;
        this.mood = null;
        this.car = null;
    }


    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate_x=" + coordinates.getX() +
                ", coordinate_y=" + coordinates.getY() +
                ", creation_date=" + creationDate +
                ", real_hero=" + realHero +
                ", has_toothpick=" + hasToothpick +
                ", impact_speed=" + impactSpeed +
                ", soundtrack_name='" + soundtrackName + '\'' +
                ", weapon_type= " + weaponType +
                ", mood=" + mood +
                ", car_name=" + car.getName()+
                ", car_cool=" + car.getCool()+
                '}';
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlElement(name = "creationdate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }
    public void setRealHero(Boolean realHero){
        this.realHero = realHero;
    }

    public boolean getHasToothpick(){
        return hasToothpick;
    }
    public void setHasToothpick(boolean hasToothpick){
        this.hasToothpick = hasToothpick;
    }

    public double getImpactSpeed(){
        return impactSpeed;
    }
    public void setImpactSpeed(double impactSpeed){
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName(){
        return soundtrackName;
    }
    public void setSoundtrackName(String soundtrackName){
        this.soundtrackName = soundtrackName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(WeaponType weaponType){
        this.weaponType = weaponType;
    }

    public Mood getMood() {
        return mood;
    }
    public void setMood(Mood mood){
        this.mood = mood;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car = car;
    }

    @Override
    public int compareTo(HumanBeing humanBeing) {
        return this.getId() - humanBeing.getId();
    }

}
