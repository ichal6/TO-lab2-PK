package States;

import Logs.ConsoleLog;

import java.util.Random;

public class AfterNotification extends  StateNotification{

    @Override
    public void execute(int ID) {
        Random random = new Random(System.currentTimeMillis());
        int returnTime = random.nextInt(4);
        ConsoleLog.log(ID, "Powrót do bazy po: " + returnTime);
    }
}
