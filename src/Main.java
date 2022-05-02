import Coordinates.Coordinates;
import JRG.JRG;
import JRG.JRGCollection;
import Notification.*;
import SKKM.SKKM;

public class Main {
    public static void main(String[] args) {
        JRGCollection jrgCollection = new JRGCollection(10);

        addJRGs(jrgCollection);

        SKKM skkm = new SKKM(jrgCollection);
        Notification fireNotification = new FireNotification(new Coordinates(50.0, 20.0));
        Notification fireNotification2 = new FireNotification(new Coordinates(50.0, 20.0));

        skkm.receiveNotification(fireNotification);
        skkm.receiveNotification(fireNotification2);
        Notification localNotification = new LocalDangerNotification(new Coordinates(50.0, 20.0));
        skkm.receiveNotification(localNotification);
    }

    private static void addJRGs(JRGCollection jrgCollection){
        JRG JRGSkawina = new JRG("JRG Skawina", new Coordinates(49.97224978359688, 19.79655221139836));
        JRG JRGSchool = new JRG("JRG Szkoły aspirantów", new Coordinates(50.077513569634725, 20.03378189976448));
        JRG LSPAirport = new JRG("LSP Lotnisko w Balicach", new Coordinates(50.07886617770602, 19.79443359213229));

        JRG JRG1 = new JRG("JRG-1", new Coordinates(50.06004384469177, 19.943838869073346));
        JRG JRG2 = new JRG("JRG-2", new Coordinates(50.033593544233234, 19.936466684417994));
        JRG JRG3 = new JRG("JRG-3", new Coordinates(50.07576800245592, 19.8880441942018));
        JRG JRG4 = new JRG("JRG-4", new Coordinates(50.03772559933986, 20.006154067218628));
        JRG JRG5 = new JRG("JRG-5", new Coordinates(50.092381607916785, 19.92247390769325));
        JRG JRG6 = new JRG("JRG-6", new Coordinates(50.01620570693408, 20.016006551872703));
        JRG JRG7 = new JRG("JRG-7", new Coordinates(50.09424633345656, 19.97743701140173));


        jrgCollection.addItem(JRGSkawina);
        jrgCollection.addItem(JRGSchool);
        jrgCollection.addItem(LSPAirport);
        jrgCollection.addItem(JRG1);
        jrgCollection.addItem(JRG2);
        jrgCollection.addItem(JRG3);
        jrgCollection.addItem(JRG4);
        jrgCollection.addItem(JRG5);
        jrgCollection.addItem(JRG6);
        jrgCollection.addItem(JRG7);
    }
}
