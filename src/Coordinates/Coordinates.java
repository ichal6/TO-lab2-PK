package Coordinates;

public class Coordinates{
    private final double latitudeN;
    private final double longitudeE;

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
                Math.pow(getLongitudeE() - otherCoordinates.getLongitudeE(), 2));
    }

}


