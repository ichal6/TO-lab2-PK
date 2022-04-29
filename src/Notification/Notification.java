package Notification;

import Cars.Car;
import Coordinates.Coordinates;
import States.StateNotification;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Notification {
    protected String name;
    protected Date date;
    protected Coordinates coordinates;
    protected StateNotification stateNotification;
    protected int numberOfCars;
    public List<Car> reservedCars;

    public Notification(String name, Coordinates coordinates){
        this.coordinates = coordinates;
        this.date = new Date(System.currentTimeMillis());
        this.name = name;
        this.reservedCars = new LinkedList<>();
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
