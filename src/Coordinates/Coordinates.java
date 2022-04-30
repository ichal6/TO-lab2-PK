package Coordinates;

import java.util.Comparator;

public class Coordinates{
    private double latitudeN;
    private double longitudeE;

    public Coordinates(double latitudeN, double longitudeE) {
        this.latitudeN = latitudeN;
        this.longitudeE = longitudeE;
    }

    public double getLatitudeN() {
        return latitudeN;
    }

    public double getLongitudeE() {
        return longitudeE;
    }

    public double compareCoordinates(Coordinates otherCoordinates){
        return Math.sqrt(Math.pow(getLatitudeN() - otherCoordinates.getLatitudeN(), 2) +
                Math.pow(getLongitudeE() - otherCoordinates.getLatitudeN(), 2));
    }
//
//    @Override
//    public int compareTo(Coordinates otherCoordinates) {
//        var result = compareCoordinates(otherCoordinates);
//
//        if( resul)
//
//        return result;
//    }

}


