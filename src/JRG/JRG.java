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
//        notification.execute(carsList);
        for (Car car: carsList){
            if(notification.getNeededCars() == 0){
                return true;
            }

            if(car.isFree()){
                car.setFree(false);
                notification.decreaseNeededCars();
                notification.reservedCars.add(car);
            }
        }

        return false;
    }

    public double compareCoordinates(Coordinates otherCoordinates){
        return this.coordinates.compareCoordinates(otherCoordinates);
    }
}
