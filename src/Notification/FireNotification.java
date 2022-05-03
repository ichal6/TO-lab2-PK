package Notification;

import Coordinates.Coordinates;
import Logs.ConsoleLog;
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
        public void run() {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                ConsoleLog.log(this.ID, "Zgłoszenie typu PZ numer: " + this.ID + "\tCzas zgłoszenia: " + formatter.format(this.date));

                runNotification();
        }



}
