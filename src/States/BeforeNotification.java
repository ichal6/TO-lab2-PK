package States;

import Logs.ConsoleLog;

import java.util.Random;

public class BeforeNotification extends StateNotification{

    @Override
    public void execute(int ID) {
        ConsoleLog.log(ID, "Wyjazd do zgłoszenia");

        Random random = new Random(System.currentTimeMillis());

        int travelTime =  random.nextInt(4);
        try {
            Thread.sleep(travelTime*1000);
        } catch (InterruptedException e) {
            ConsoleLog.log(ID, "Błąd zgłoszenia");
        }

        ConsoleLog.log(ID, "Dojazd na miejsce zdarzena trwał: ", travelTime);
    }
}
