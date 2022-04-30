package Notification;

import Cars.Car;
import Coordinates.Coordinates;
import States.DuringNotification;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class FireNotification extends Notification{
        public FireNotification(Coordinates coordinates) {
                super(coordinates);
                this.numberOfCars = 3;
        }

        @Override
        public void execute() {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Random random = new Random();

                this.stateNotification = new DuringNotification();
                System.out.println("Zgłoszenie numer: " + Notification.number + "\nDojazd na miejsce: " + formatter.format(this.date));


                int travelTime =  random.nextInt(4);

                boolean isFalseNotification =  random.nextInt(0, 100) <= 10;

                System.out.println("Dojazd na miejsce zdarzena trwał: " + travelTime);

                if(isFalseNotification){
                        System.out.println("Zdarzenie fałszywe");
                } else{
                        System.out.println("Zdarzenie prawdziwe");

                        System.out.println("Trwa operacja ratownicza");
                        int operationTime =  random.nextInt(5, 26);
                        System.out.println("Operacja zakończona po: " + operationTime);
                }

                System.out.print("Powrót do bazy po: ");
                int returnTime = random.nextInt(4);
                System.out.println(returnTime);
        }
}
