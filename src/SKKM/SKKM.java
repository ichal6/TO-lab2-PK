package SKKM;

import Coordinates.Coordinates;
import Iterator.*;
import JRG.JRG;
import Notification.Notification;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SKKM {
//    private List<JRG> JRGunits;
    private List<Notification> notificationsList;
    private Iterator iterator;
    private Queue<Notification> waitingNotifications;

    public SKKM() {
//        this.JRGunits = new LinkedList<>();
        this.notificationsList = new LinkedList<>();
        this.waitingNotifications = new LinkedList<>();
    }

    public void notify(Notification notification){



//        for (JRG unit: JRGunits) {
//            var isFullyAccepted = unit.update(notification);
//            if(isFullyAccepted){
//                break;
//            }
//        }
    }

    public void receiveNotification(Notification notification) {
        this.iterator = createIterator(notification.getCoordinates());
        while(iterator.hasMore()){
            JRG unit = iterator.getNext();
            boolean isFullyAccepted = unit.update(notification);
            if(isFullyAccepted){
                notification.execute();
                break;
            }
        }

        waitingNotifications.add(notification);
    }

    private Iterator createIterator(Coordinates coordinates){
        return new JRGIterator(coordinates);
    }


}
