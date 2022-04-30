package Notification;

import Coordinates.Coordinates;
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
    public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("Zgłoszenie typu MZ numer: " + this.ID + "\nCzas zgłoszenia: " + formatter.format(this.date));

        this.stateNotification = new BeforeNotification();
        this.stateNotification.execute();

        this.stateNotification = new DuringNotification();
        this.stateNotification.execute();

        this.stateNotification = new AfterNotification();
        this.stateNotification.execute();

        notifyCars();
    }
}
