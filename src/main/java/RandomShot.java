import java.util.Random;

public class RandomShot {
public static int RandomShot () {
        Random generator = new Random();

            int s = generator.nextInt(10);
            return s;

    }
}
