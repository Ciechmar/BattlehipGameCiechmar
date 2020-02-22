import java.util.Scanner;

public class App2Players {

    public static void main(String[] args) {
        System.out.println( "Witaj w grze dla dwóch graczy\nTablcia jest 7x7 ->Czyli do G7");
        System.out.println("Gracz 1 podaj pozycje statków (10) rozdzielone spacja/przecinkiem");
        Scanner scanner = new Scanner(System.in);
        String ships1 = scanner.nextLine();
        for (int i = 0; i <100 ; i++) {
            System.out.println();
        }
        System.out.println("Zapraszam gracza 2");
        System.out.println("Gracz 2 podaj pozycje statków (10) rozdzielone spacja/przecinkiem");
        String ships2 = scanner.nextLine();
        for (int i = 0; i <50 ; i++) {
            System.out.println();
        }
            String shot1 = StringToShot.stringToShot(0, 1, ships1);
            String shot2 = StringToShot.stringToShot(3, 4, ships1);
            String shot3 = StringToShot.stringToShot(6, 7, ships1);
            String shot4 = StringToShot.stringToShot(9, 10, ships1);
            String shot5 = StringToShot.stringToShot(12, 13, ships1);
            String shot6 = StringToShot.stringToShot(15, 16, ships1);
            String shot7 = StringToShot.stringToShot(18, 19, ships1);
            String shot8 = StringToShot.stringToShot(21, 22, ships1);
            String shot9 = StringToShot.stringToShot(24, 25, ships1);
            String shot10= StringToShot.stringToShot(27, 28, ships1);

            String shot21 = StringToShot.stringToShot(0, 1, ships2);
            String shot22 = StringToShot.stringToShot(3, 4, ships2);
            String shot23 = StringToShot.stringToShot(6, 7, ships2);
            String shot24 = StringToShot.stringToShot(9, 10, ships2);
            String shot25 = StringToShot.stringToShot(12, 13, ships2);
            String shot26 = StringToShot.stringToShot(15, 16, ships2);
            String shot27 = StringToShot.stringToShot(18, 19, ships2);
            String shot28 = StringToShot.stringToShot(21, 22, ships2);
            String shot29 = StringToShot.stringToShot(24, 25, ships2);
            String shot210= StringToShot.stringToShot(27, 28, ships2);
//          Do zautomatyzowania jak bede umiała już tworzyć zmienne przez jave.
//        for (int i = 0; i <ships1.length() ; i=i+3) {
//            StringBuffer shot1 = StringToShot.stringToShot(i, i+1, ships1);
//            System.out.println("Pierwszy strzał to " + shot1);
//        }

        byte userBoard1[][] = new byte[7][7];
        byte userBoardB[][] = new byte[7][7];
        byte hit1 = 0;
        byte hitB = 0;
        while (hit1 < 10 && hitB < 10) {

            System.out.println("GRACZ 1\n");
            System.out.println("   A  B  C  D  E  F  G");
            for (int i = 0; i < 7; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < 7; j++) {
                    if (userBoard1[i][j] == 0) {
                        System.out.print("[ ]");
                    } else if (userBoard1[i][j] == 1) {
                        System.out.print("[X]");
                    } else System.out.print("[*]");
                }
                System.out.println();
            }
            System.out.println("\nPodaj strzał");
            String shot = scanner.nextLine();
            shot = shot.toUpperCase();

            byte a = HitorMiss.hitOrMiss(shot, shot1, shot2, shot3, shot4, shot5, shot6, shot7, shot8, shot9, shot10);
            hit1 = (byte) (hit1+a); /* Czemu tu wymusza rzutowanie? -> W celu zabezpieczniea się, żeby nie wyszło za przedział liczbowy byte */
            char shotNum = shot.charAt(1);
            byte shotNumber= (byte) Character.getNumericValue(shotNum);

            if (a ==1) {
                userBoard1[shotNumber - 1][ShotToCords.shotToCords(shot)] = 1;
                System.out.println(" Trafiony\n");
            } else {
                System.out.println("Pudło\n");
                userBoard1[shotNumber - 1][ShotToCords.shotToCords(shot)] = 3;

            }
            System.out.println("GRACZ 2\n");
            System.out.println("   A  B  C  D  E  F  G");
            for (int i = 0; i < 7; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < 7; j++) {
                    if (userBoardB[i][j] == 0) {
                        System.out.print("[ ]");
                    } else if (userBoardB[i][j] == 1) {
                        System.out.print("[X]");
                    } else System.out.print("[*]");
                }
                System.out.println();
            }
            System.out.println("\nPodaj strzał");
            String shotB= scanner.nextLine();
            shotB = shotB.toUpperCase();

            Byte b = HitorMiss.hitOrMiss(shotB, shot21, shot22, shot23, shot24, shot25, shot26, shot27, shot28, shot29, shot210);
            hitB = (byte) (hitB+b); /* Czemu tu wymusza rzutowanie? */
            char shotNumB = shotB.charAt(1);
            byte shotNumberB= (byte) Character.getNumericValue(shotNumB);

            if (b ==1) {
                userBoardB[shotNumberB - 1][ShotToCords.shotToCords(shotB)] = 1;
                System.out.println(" Trafiony\n");
            } else {
                System.out.println("Pudło\n");
                userBoardB[shotNumberB - 1][ShotToCords.shotToCords(shotB)] = 3;
            }
        }

        if (hit1 == 10 ) {
            System.out.println("Wygrał Gracz 1 \n Gratulacje");
        } else if (hitB == 10){
            System.out.println("Wygrał Gracz 2\n Gratulacje");
        } else System.out.println("Remis!");
        System.out.println("Może rewanż? ;)");
    }
}
