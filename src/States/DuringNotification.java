package States;

import java.util.Random;

public class DuringNotification extends StateNotification{
    @Override
    public void execute() {
        Random random = new Random(System.currentTimeMillis());
        boolean isFalseNotification =  random.nextInt(0, 100) <= 5;
        if(isFalseNotification){
            System.out.println("Zdarzenie fałszywe");
        } else{
            System.out.println("Zdarzenie prawdziwe");

            System.out.println("Trwa operacja ratownicza");
            int operationTime =  random.nextInt(5, 26);
            System.out.println("Operacja zakończona po: " + operationTime);
        }
    }
}
