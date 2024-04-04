package data.comporators;

import data.HumanBeing;

import java.util.Comparator;

public class HumanBeingComparator implements Comparator<HumanBeing> {
    @Override
    public int compare(HumanBeing h1, HumanBeing h2){
        return h1.getCoordinates().getVektor(h1.getCoordinates().getX(), h1.getCoordinates().getY()) - h2.getCoordinates().getVektor(h2.getCoordinates().getX(), h2.getCoordinates().getY());
    }
}
