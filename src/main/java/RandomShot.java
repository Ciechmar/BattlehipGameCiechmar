import java.util.Random;

public class RandomShot {
public static int RandomShot () {
        Random generator = new Random();

            int s = generator.nextInt(9);
//            Do 9, bo nie działa strzelanie w pozycje 10 ;)
            return s;

    }
}
