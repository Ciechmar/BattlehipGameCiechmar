public class ShotToCords {
    public static byte shotToCords(String shot) {
        char a = shot.charAt(0);

        switch (a) {
            case 'A':
                return 0;

            case 'B':
                return 1;

            case 'C':
                return 2;

            case 'D':
                return 3;

            case 'E':
                return 4;

            case 'F':
                return 5;

            case 'G':
                return 6;

            case 'H':
                return 7;



            default:
                throw new IllegalStateException("Podałeś strzał z poza tablicy " + shot);
        }

    }
}
