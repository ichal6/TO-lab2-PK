package JRG;

import Cars.Car;
import Coordinates.Coordinates;
import Notification.Notification;
import SKKM.SKKM;

import java.util.ArrayList;
import java.util.List;

public class JRG{
    private final int NUMBER_OF_CARS = 5;
    private String name;
    private List<Car> carsList;
    private SKKM skkmCenter;
    private Notification notification;
    private Coordinates coordinates;

    public JRG(String name,  Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;

        this.carsList = new ArrayList<>();
        addCars();
    }

    public void addCars(){
        for(int i = 0; i < NUMBER_OF_CARS; i++) {
            Car newCar = new Car();
            this.carsList.add(newCar);
        }
    }

    public boolean update(Notification notification) {
        this.notification = notification;
        for (Car car: carsList){
            if(car.isFree()){
                car.update(false);
                notification.decreaseNeededCars();
                notification.addCar(car);
            }

            if(notification.getNeededCars() == 0){
                return true;
            }
        }

        return false;
    }

    public void reset(){
        for(Car car: carsList){
            if(notification.containCar(car)){
                notification.detachCar(car);
                car.update(true);
            }
        }
    }

    public double compareCoordinates(Coordinates otherCoordinates){
        return this.coordinates.compareCoordinates(otherCoordinates);
    }

}
