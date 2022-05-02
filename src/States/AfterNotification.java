package States;

import Logs.ConsoleLog;

import java.util.Random;

public class AfterNotification extends  StateNotification{

    @Override
    public void execute(int ID) {
        Random random = new Random(System.currentTimeMillis());
        int returnTime = random.nextInt(4);
        try {
            Thread.sleep(returnTime*1000);
        } catch (InterruptedException e) {
            ConsoleLog.log(ID, "Błąd zgłoszenia");
        }
        ConsoleLog.log(ID, "Powrót do bazy po: ", returnTime);
    }
}
