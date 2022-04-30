package Notification;

import Coordinates.Coordinates;
import States.AfterNotification;
import States.BeforeNotification;
import States.DuringNotification;

import java.text.SimpleDateFormat;

public class FireNotification extends Notification{
        public FireNotification(Coordinates coordinates) {
                super(coordinates);
                this.numberOfCars = 3;
        }

        @Override
        public void execute() {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                System.out.println("Zgłoszenie typu PZ numer: " + this.ID + "\nCzas zgłoszenia: " + formatter.format(this.date));

                this.stateNotification = new BeforeNotification();
                this.stateNotification.execute();

                this.stateNotification = new DuringNotification();
                this.stateNotification.execute();

                this.stateNotification = new AfterNotification();
                this.stateNotification.execute();

                notifyCars();
        }

}
