package Notification;

import Cars.Car;
import Coordinates.Coordinates;
import States.StateNotification;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Notification {
    protected static int counter = 1;
    protected int ID;
    protected Date date;
    protected Coordinates coordinates;
    protected StateNotification stateNotification;
    protected int numberOfCars;
    public List<Car> reservedCars;

    public Notification( Coordinates coordinates){
        this.coordinates = coordinates;
        this.date = new Date(System.currentTimeMillis());
        this.reservedCars = new LinkedList<>();
        this.ID = counter++;
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

    public void addCar(Car car){
        this.reservedCars.add(car);
    }

    public void detachCar(Car car){
        this.reservedCars.remove(car);
    }

    public void notifyCars(){
        for( Car car: reservedCars){
            car.update(true);
        }
    }
}
