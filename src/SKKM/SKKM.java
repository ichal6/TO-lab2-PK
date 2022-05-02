package SKKM;

import Iterator.*;
import JRG.*;
import Notification.Notification;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SKKM{
    private JRGCollection JRGunits;
    private List<Notification> notificationsList;
    private Iterator iterator;
    private Queue<Notification> waitingNotifications;

    public SKKM(JRGCollection jrgCollection) {
        this.JRGunits = jrgCollection;
        this.notificationsList = new LinkedList<>();
        this.waitingNotifications = new LinkedList<>();
    }

    public void receiveNotification(Notification notification) {
        this.iterator = JRGunits.createIterator(notification.getCoordinates());
        while(iterator.hasMore()){
            JRG unit = iterator.getNext();
            boolean isFullyAccepted = unit.update(notification);
            if(isFullyAccepted){
                notification.execute();
                return;
            }
        }

        waitingNotifications.add(notification);
    }

}
