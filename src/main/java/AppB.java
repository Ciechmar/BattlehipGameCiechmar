import java.util.Scanner;
//TODO: Strzały na pozycji 10!!,
// Dolosowanie brakującego statku (gdy wylosował te same)- następna pętla... łeeeeee :(;
// Rozdział na metody
//

public class AppB {
    public static void main(String[] args) {
//Deklaracje na początku- troche wieje Pascalem ;)
        Scanner scanner = new Scanner(System.in);
        int countHitMy = 0;
        int countHit = 0;
        int howManyShots = 0;
//        Tutaj deklaruję swoją tablicę

        byte board[][] = new byte[10][10];

        //Najpierw zapełniam tablice zerami
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0;

            }
        }

        System.out.println("Witaj w grze w Statki.");
        System.out.println("Masz do wyboru dwa warianty gry:\n" +
                "1)Moja tablica- klasyczna, 1x 4masztowiec, 2x 3masztowce idt\n" +
                "2)Losowa. Ty podajesz ile ma być jednomasztowców\n" +
                "3) Wyjście z gry. \nCo wybierasz? 1,2 czy 3?");
        byte option = scanner.nextByte();

        if (option == 1 ) {
            //Wstawiam swoje statki

            board[0][1] = 1;
            board[0][9] = 1;
            board[0][6] = 1;
            board[0][7] = 1;
            board[0][8] = 1;
            board[2][2] = 1;
            board[2][5] = 1;
            board[3][2] = 1;
            board[4][6] = 1;
            board[4][7] = 1;
            board[5][1] = 1;
            board[5][9] = 1;
            board[6][9] = 1;
            board[7][0] = 1;
            board[7][1] = 1;
            board[7][3] = 1;
            board[7][9] = 1;
            board[8][3] = 1;
            board[8][6] = 1;
            board[9][3] = 1;
        } else if (option == 3) {
//          Warunek wykonywania gry. Tutaj uznaje, że wszystkie statki zestrzelone i wyłazi w ogóle z gry.
            countHit = countHitMy;
        }

            else {
            //Wstawiam losowo statki
            System.out.println("No to losowanko");
            System.out.println("Ile ma być statków?");
            int ilosc = scanner.nextInt();
            int randomShips = 0;
            while (randomShips <= ilosc-1) {
                board[RandomShot.RandomShot()][RandomShot.RandomShot()] = 1;

                //Sprawdzenie ile jest podanych statków
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        randomShips = randomShips + board[i][j];
                        System.out.println("ilosc randomow " + randomShips);

                    }

                }
            }
        }




//            else {
//            //Wstawiam losowo statki
//            System.out.println("No to losowanko");
//            System.out.println("Ile ma być statków?");
//            int ilosc = scanner.nextInt();
//            for (int i = 0; i < ilosc; i++) {
//                board[RandomShot.RandomShot()][RandomShot.RandomShot()] = 1;
//            }
//        }

//Sprawdzenie ile jest podanych statków

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                countHitMy = countHitMy + board[i][j];
                System.out.println("ilosc"+countHitMy);

            }

        }
// Koniec mojej tablicy










// Tutaj robimy tablice ze statkami usera

        short userBoard[][] = new short[10][10];

//Zapełniam tablice zerami, bo na poczatku nie ma żadnych strzałów i statków
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userBoard[i][j] = 0;

            }
        }
//  Koniec tablicy usera


//Zapętalmy by grać aż countHit =countHitMy -> tyle jest statków na tablicy, czyli wszystkie statki będą zestrzelone


        while (countHit < countHitMy ) {
            System.out.printf("Jest %d statków do zbicia\n", countHitMy - countHit);

//    Wyświetlam tablice
//                [ ]- brak strzału 0
//                [*]- miss 3
//                [X]- hit  1
            System.out.println("   A  B  C  D  E  F  G  H  I  J");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < 10; j++) {
                    if (userBoard[i][j] == 0) {
                        System.out.print("[ ]");
                    } else if (userBoard[i][j] == 1) {
                        System.out.print("[X]");
                    } else System.out.print("[*]");

                }
                System.out.println();
            }

            int shotVertical = 0;
            int shotHorizontal = 0;

            System.out.println(" \n\nPodaj strzał");
            String shot = scanner.next();
            String shotBig = shot.toUpperCase();
            char shotVerticalLetter = shotBig.charAt(0);

            char shotHorizontalLetter = shotBig.charAt(1);
            shotHorizontal = Character.getNumericValue(shotHorizontalLetter);


// Zmiana wyboru na pozycje w postaci int - Przy okazji nie trzeba potem odejmować 1 od pozycji w tablicy
            switch (shotVerticalLetter) {
                case 'A':
                    shotVertical = 0;
                    break;
                case 'B':
                    shotVertical = 1;
                    break;
                case 'C':
                    shotVertical = 2;
                    break;
                case 'D':
                    shotVertical = 3;
                    break;
                case 'E':
                    shotVertical = 4;
                    break;
                case 'F':
                    shotVertical = 5;
                    break;
                case 'G':
                    shotVertical = 6;
                    break;
                case 'H':
                    shotVertical = 7;
                    break;
                case 'I':
                    shotVertical = 8;
                    break;
                case 'J':
                    shotVertical = 9;
                    break;
                case '9':
//  Gdy gracz chce wyjść wpisuje 99. Muszę sprawdzić tylko pierwszą pozycję czy jest to literka czy 9.
//  Wtedy wstępny warunek do pętli jest spełniony i wychodzi z petli.
                    countHit = countHitMy;
                    howManyShots = howManyShots -1;
                    break;
            }


            if (shotHorizontal != 99) {

                System.out.printf("Wybrałeś %s %s \n", shotVerticalLetter, shotHorizontal);
                howManyShots++;

                if (board[shotHorizontal - 1][shotVertical] == 0) {
                    System.out.println("Pudło :(\n");
                    userBoard[shotHorizontal - 1][shotVertical] = 3;
                } else if (board[shotHorizontal - 1][shotVertical] == 1) {
//    Odejmuję 1, bo counHit doda się dopiero później

                    System.out.println("Trafiony :)\n");
                    userBoard[shotHorizontal - 1][shotVertical] = 1;
                    countHit++;
                }
            }

        }

//        double s = countHitMy;
//        double h = howManyShots;
//        System.out.println("Zmienne s i h to:"+s+h);
//        double percent = s*100.0/h;
        System.out.printf("Oddałeś %d strzałów. Dzięki za grę", howManyShots);
//        System.out.printf("Twoja celność to: %.2f", percent);
    }

}
