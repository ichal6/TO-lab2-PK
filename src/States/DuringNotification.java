package States;

import Logs.ConsoleLog;

import java.util.Random;

public class DuringNotification extends StateNotification{
    @Override
    public void execute(int ID) {
        Random random = new Random(System.currentTimeMillis());
        boolean isFalseNotification =  random.nextInt(0, 100) <= 5;
        if(isFalseNotification){
            ConsoleLog.log(ID, "Zdarzenie fałszywe");
        } else{
            ConsoleLog.log(ID,"Zdarzenie prawdziwe");

            ConsoleLog.log(ID,"Trwa operacja ratownicza");
            int operationTime =  random.nextInt(5, 26);

            try {
                Thread.sleep(operationTime*1000);
            } catch (InterruptedException e) {
                ConsoleLog.log(ID, "Błąd zgłoszenia");
            }
            ConsoleLog.log(ID,"Operacja zakończona po: ", operationTime);
        }
    }
}
