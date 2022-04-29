import Coordinates.Coordinates;
import Notification.*;
import SKKM.SKKM;

public class Main {
    public static void main(String[] args) {
        SKKM skkm = new SKKM();
        Notification fireNotification = new FireNotification("First fire notation", new Coordinates(50.0, 20.0));
        skkm.receiveNotification(fireNotification);
    }
}
