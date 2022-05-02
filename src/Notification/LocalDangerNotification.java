package Notification;

import Coordinates.Coordinates;
import Logs.ConsoleLog;
import States.AfterNotification;
import States.BeforeNotification;
import States.DuringNotification;

import java.text.SimpleDateFormat;

public class LocalDangerNotification extends Notification{
    public LocalDangerNotification(Coordinates coordinates) {
        super(coordinates);
        this.numberOfCars = 2;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        ConsoleLog.log(this.ID, "Zgłoszenie typu MZ numer: " + this.ID + "\tCzas zgłoszenia: " + formatter.format(this.date));

        this.stateNotification = new BeforeNotification();
        this.stateNotification.execute(this.ID);

        this.stateNotification = new DuringNotification();
        this.stateNotification.execute(this.ID);

        this.stateNotification = new AfterNotification();
        this.stateNotification.execute(this.ID);

        notifyCars();
    }
}
