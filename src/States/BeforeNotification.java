package States;

import java.text.SimpleDateFormat;
import java.util.Random;

public class BeforeNotification extends StateNotification{

    @Override
    public void execute() {
        Random random = new Random(System.currentTimeMillis());

        int travelTime =  random.nextInt(4);

        System.out.println("Dojazd na miejsce zdarzena trwał: " + travelTime);
    }
}
