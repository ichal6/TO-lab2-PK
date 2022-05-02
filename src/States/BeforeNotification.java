package States;

import Logs.ConsoleLog;

import java.util.Random;

public class BeforeNotification extends StateNotification{

    @Override
    public void execute(int ID) {
        Random random = new Random(System.currentTimeMillis());

        int travelTime =  random.nextInt(4);

        ConsoleLog.log(ID, "Dojazd na miejsce zdarzena trwał: " + travelTime);
    }
}
