import java.sql.SQLOutput;
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
//        System.out.println("Gracz 2 podaj pozycje statków (10) rozdzielone spacja/przecinkiem");
//        String ships2 = scanner.next();
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


//          Do zautomatyzowania jak bede umiała już tworzyć zmienne przez jave.
//        for (int i = 0; i <ships1.length() ; i=i+3) {
//            StringBuffer shot1 = StringToShot.stringToShot(i, i+1, ships1);
//            System.out.println("Pierwszy strzał to " + shot1);
//        }

        byte userBoard[][] = new byte[7][7];
        byte hit = 0;

        while (hit < 10) {

            //    Wyświetlam tablice
//                [ ]- brak strzału 0
//                [*]- miss 3
//                [X]- hit  1
            System.out.println("   A  B  C  D  E  F  G");
            for (int i = 0; i < 7; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < 7; j++) {
                    if (userBoard[i][j] == 0) {
                        System.out.print("[ ]");
                    } else if (userBoard[i][j] == 1) {
                        System.out.print("[X]");
                    } else System.out.print("[*]");
                }
                System.out.println();
            }



            System.out.println("\nPodaj strzał");
            String shot = scanner.nextLine();
            shot = shot.toUpperCase();

            Byte a = HitorMiss.hitOrMiss(shot, shot1, shot2, shot3, shot4, shot5, shot6, shot7, shot8, shot9, shot10);
            hit = (byte) (hit+a); /* Czemu tu wymusza rzutowanie? */
            char shotNum = shot.charAt(1);
            byte shotNumber= (byte) Character.getNumericValue(shotNum);

            if (a ==1) {
                userBoard[shotNumber - 1][ShotToCords.shotToCords(shot)] = 1;
                System.out.println(" Trafiony");
            } else {
                System.out.println("Pudło");
                userBoard[shotNumber - 1][ShotToCords.shotToCords(shot)] = 3;

            }



        }








    }
}
