import Coordinates.Coordinates;
import JRG.JRG;
import JRG.JRGCollection;
import Notification.*;
import SKKM.SKKM;

public class Main {
    public static void main(String[] args) {
        JRGCollection jrgCollection = new JRGCollection(10);
//        JRG JRGSkawina = new JRG();

        SKKM skkm = new SKKM(jrgCollection);
        Notification fireNotification = new FireNotification("First fire notation", new Coordinates(50.0, 20.0));
        skkm.receiveNotification(fireNotification);
    }
}
