package SKKM;

import Iterator.*;
import JRG.*;
import Notification.Notification;

import java.util.LinkedList;
import java.util.Queue;

public class SKKM{
    private JRGCollection JRGunits;
    private Iterator iterator;
    private Queue<Notification> waitingNotifications;

    public SKKM(JRGCollection jrgCollection) {
        this.JRGunits = jrgCollection;
        this.waitingNotifications = new LinkedList<>();
    }

    public void receiveNotification(Notification notification) {
        if(!waitingNotifications.isEmpty()){
            waitingNotifications.add(notification);
            notification = waitingNotifications.element();
        }

        assignCarToNotification(notification);
    }

    public boolean isWaitingNotifications(){
        return waitingNotifications.poll() != null;
    }

    public void executeWaitingNotifications(){
        if(waitingNotifications.isEmpty()){
            return;
        }

        Notification notification = waitingNotifications.element();
        assignCarToNotification(notification);

    }

    private void assignCarToNotification(Notification notification){
        this.iterator = JRGunits.createIterator(notification.getCoordinates());
        while(iterator.hasMore()){
            JRG unit = iterator.getNext();
            boolean isFullyAccepted = unit.update(notification);
            if(isFullyAccepted){
                notification.execute();
                return;
            }
        }

        JRGunits.notifyAllUnits();

        if(!waitingNotifications.offer(notification)){
            waitingNotifications.add(notification);
        }
    }
}
