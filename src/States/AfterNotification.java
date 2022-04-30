package States;

import java.util.Random;

public class AfterNotification extends  StateNotification{

    @Override
    public void execute() {
        Random random = new Random(System.currentTimeMillis());
        System.out.print("Powrót do bazy po: ");
        int returnTime = random.nextInt(4);
        System.out.println(returnTime + "\n");
    }
}
