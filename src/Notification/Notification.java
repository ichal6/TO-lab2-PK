package Notification;

import Cars.Car;
import Coordinates.Coordinates;
import States.AfterNotification;
import States.BeforeNotification;
import States.DuringNotification;
import States.StateNotification;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Notification implements Runnable{
    protected static int counter = 1;
    protected int ID;
    protected Date date;
    protected Coordinates coordinates;
    protected StateNotification stateNotification;
    protected int numberOfCars;
    protected List<Car> reservedCars;
    protected Thread thread;

    public Notification( Coordinates coordinates){
        this.coordinates = coordinates;
        this.date = new Date(System.currentTimeMillis());
        this.reservedCars = new LinkedList<>();
        this.ID = counter++;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void execute(){
        if(this.thread == null){
            this.thread = new Thread(this, String.valueOf(ID));
            thread.start();
        }
    }

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

    public boolean containCar(Car car){
        return this.reservedCars.contains(car);
    }

    protected void runNotification(){
        this.stateNotification = new BeforeNotification();
        this.stateNotification.execute(this.ID);

        this.stateNotification = new DuringNotification();
        this.stateNotification.execute(this.ID);

        this.stateNotification = new AfterNotification();
        this.stateNotification.execute(this.ID);

        notifyCars();
    }
}
