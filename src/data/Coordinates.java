package data;

import javax.xml.bind.annotation.XmlElement;

public class Coordinates {
    private Integer x;
    private Long y;

    public Coordinates(){}

    public Coordinates(Integer x, Long y){
        this.x = x;
        this.y = y;
    }


    public Integer getX(){
        return x;
    }
    public void setX(Integer x){
        this.x = x;
    }

    public Long getY(){
        return y;
    }

    public void setY(Long y){
        this.y = y;
    }

    public int getVektor(int x, long y){
        return Integer.parseInt(String.valueOf(Math.sqrt(x^2 + y^2)));
    }
}
