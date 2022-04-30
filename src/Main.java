import Cars.Car;
import Coordinates.Coordinates;
import JRG.JRG;
import JRG.JRGCollection;
import Notification.*;
import SKKM.SKKM;

public class Main {
    public static void main(String[] args) {
        JRGCollection jrgCollection = new JRGCollection(1);
        JRG JRGSkawina = new JRG("JRG Skawina", new Coordinates(49.97224978359688, 19.79655221139836));
        jrgCollection.addItem(JRGSkawina);

        SKKM skkm = new SKKM(jrgCollection);
        Notification fireNotification = new FireNotification(new Coordinates(50.0, 20.0));
        Notification fireNotification2 = new FireNotification(new Coordinates(50.0, 20.0));

        skkm.receiveNotification(fireNotification);
        skkm.receiveNotification(fireNotification2);
        Notification localNotification = new LocalDangerNotification(new Coordinates(50.0, 20.0));
        skkm.receiveNotification(localNotification);
    }
}
