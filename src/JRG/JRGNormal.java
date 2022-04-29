package JRG;

import Cars.Car;
import Coordinates.Coordinates;
import Notification.Notification;
import SKKM.SKKM;

import java.util.List;

public class JRGNormal extends JRG{
    private String name;
    private List<Car> carsList;
    private SKKM skkmCenter;
    private Coordinates coordinates;

    @Override
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
}
