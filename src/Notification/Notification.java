package Notification;

import Cars.Car;
import Coordinates.Coordinates;
import States.StateNotification;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Notification {
    protected static int number = 0;
    protected Date date;
    protected Coordinates coordinates;
    protected StateNotification stateNotification;
    protected int numberOfCars;
    public List<Car> reservedCars;

    public Notification( Coordinates coordinates){
        this.coordinates = coordinates;
        this.date = new Date(System.currentTimeMillis());
        this.reservedCars = new LinkedList<>();
        number += 1;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public abstract void execute();

    public int getNeededCars() {
        return this.numberOfCars;
    }

    public void decreaseNeededCars() {
        this.numberOfCars -= 1;
    }
}
