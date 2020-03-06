import java.util.Random;
import java.util.Scanner;

public class AppB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Tutaj deklaruję swoją tablicę
        byte[][] board;
        board = new byte[17][17];

        System.out.println("Witaj w grze w Statki.");
        System.out.println("Masz do wyboru dwa warianty gry:\n" +
                "1)Moja tablica- klasyczna, 1x 4masztowiec, 2x 3masztowce idt\n" +
                "2)Losowa. Ty podajesz ile ma być jednomasztowców\n" +
                "3) Wylosowane przez komputer\n" +
                "4) Wyjście z gry (W każdej chwili możesz też wpisać '99' i wyjdziesz" +
                " \nCo wybierasz? 1,2 czy 3?");
        byte option = scanner.nextByte();

        int countHitUserBoard = 0;
        int howManyShots = 0;
        int howManyShipsOnBoard = 0;


        switch (option) {
            case 1: {
//Wstawiam swoje statki

                board[4 ][5 ] = 1;
                board[4 ][13] = 1;
                board[4 ][10] = 1;
                board[4 ][11] = 1;
                board[4 ][12] = 1;
                board[6 ][6 ] = 1;
                board[6 ][9 ] = 1;
                board[7 ][6 ] = 1;
                board[8 ][10] = 1;
                board[8 ][11] = 1;
                board[9 ][5 ] = 1;
                board[9 ][13] = 1;
                board[10][13] = 1;
                board[11][4 ] = 1;
                board[11][5 ] = 1;
                board[11][7 ] = 1;
                board[11][13] = 1;
                board[12][7 ] = 1;
                board[12][10] = 1;
                board[13][7 ] = 1;
                break;
            }
            case 4: {
//          Warunek wykonywania gry. Tutaj uznaje, że wszystkie statki zestrzelone i wyłazi w ogóle z gry.
                countHitUserBoard = howManyShipsOnBoard;
                break;
            }

            case 3: {
                System.out.println("Uwaga losuję");

                //        Zaznaczam obszary niedozwolone do strzału
                for (int i = 3; i < 14; i++) {
                    board[i][14] = 9;
                    board[i][15] = 9;
                    board[i][16] = 9;
                    board[14][i] = 9;
                    board[15][i] = 9;
                    board[16][i] = 9;
                }

                for (int i = 3; i < 14; i++) {
                    board[i][3] = 9;
                    board[i][2] = 9;
                    board[i][1] = 9;
                    board[3][i] = 9;
                    board[2][i] = 9;
                    board[1][i] = 9;
                }

                int id;
                int whitchShip = 0;
                for (int n = 0; n < 10 ; n++) {
                    id = n;
                    switch (id){
                        case 0: whitchShip = 4; break;
                        case 1:
                        case 2: whitchShip = 3; break;
                        case 3:
                        case 4:
                        case 5: whitchShip = 2; break;
                        case 6:
                        case 7:
                        case 8:
                        case 9: whitchShip = 1; break;
                    }

                    byte varForPuttingShip = 0;
                    int isSpotFree = 0;

                    do {
                        Random generator = new Random();
                        int i = generator.nextInt(9);
                        int j = generator.nextInt(9);

                        i = i + 4;
                        j = j + 4;

//        Losowanie kierunku:
                        int k = generator.nextInt(2);
                        if (k == 1) { /*Ułożenie pionowe*/


                            while (isSpotFree < whitchShip) {

                                if (board[i + isSpotFree][j] == 0) {
                                    isSpotFree++;
                                } else {
                                    break;
                                }
                            }

//Jeżeli np.: dla 4 masztowca  putShip = 4 (czyli 4 miejsca były wolne) to  można postawić statek
                            if (isSpotFree == whitchShip) {
                                for (int m = 0; m < whitchShip; m++) {
                                    board[i + m][j] = 1;

                                }
                                varForPuttingShip = 1;
                            }

                        } else { /*ułożenie poziome*/

                            while (isSpotFree < whitchShip) {

                                if (board[i][j + isSpotFree] == 0) {
                                    isSpotFree++;
                                } else {
                                    break;
                                }
                            }
                            if (isSpotFree == whitchShip) {

                                for (int m = 0; m < whitchShip; m++) {
                                    board[i][j + m] = 1;

                                }
                                varForPuttingShip = 1;
                            }
                        }

// ToDo: Wstawienie 9 w miejsca niedozwolone:

                        for (int l = 4; l <14 ; l++) {
                            for (int m = 4; m <14 ; m++) {
                                if ( board[i][j] == 1 ) {
                                    if (board [i + 1][j] == 0) {board [i + 1][j] = 9;}
                                    if (board [i - 1][j] == 0) {board [i - 1][j] = 9;}

                                    if (board [i][j + 1] == 0) {board [i][j + 1] = 9;}
                                    if (board [i][j - 1] == 0) {board [i][j - 1] = 9;}

                                    if (board [i + 1][j + 1] == 0) {board [i + 1][j] = 9;}
                                    if (board [i - 1][j - 1] == 0) {board [i - 1][j] = 9;}
                                    if (board [i + 1][j - 1] == 0) {board [i - 1][j] = 9;}
                                    if (board [i - 1][j + 1] == 0) {board [i - 1][j] = 9;}
                                }
                            }
                        }

                    } while (varForPuttingShip != 1);

                }
                System.out.println("   A  B  C  D  E  F  G  H  I  J");
                for (int i =4; i < 14; i++) {
                    System.out.print(i -3 + " ");
                    for (int j = 4; j < 14; j++) {
                        if (board[i][j] == 0) {
                            System.out.print("[ ]");
                        } else if (board[i][j] == 1) {
                            System.out.print("[X]");
                        } else System.out.print("[*]");
                    }
                    System.out.println();
                }

                break;
            }

            case 2: {
//Wstawiam losowe pojedyncze statki
                System.out.println("No to losowanko");
                System.out.println("Ile ma być statków?");
                int ilosc = scanner.nextInt();
                int randomShips = 0;
                while (randomShips < ilosc) {
                    int s = RandomShot.RandomShot();
                    int h = RandomShot.RandomShot();
                    if (board[s + 4][h + 4] == 0) {
                        board[s + 4][h + 4] = 1;
                        randomShips++;
                    }
                }
                break;
            }

            default: {
                System.out.println("Nie ma takiej opcji. Wychodzę z gry");
                countHitUserBoard = howManyShipsOnBoard;
                break;
            }


        }
//Sprawdzenie ile jest podanych statków

        for (int i = 4; i < 14; i++) {
            for (int j = 4; j < 14; j++) {
                if (board[i][j] ==1){
                howManyShipsOnBoard = howManyShipsOnBoard + board[i][j];}
            }
        }

// Koniec mojej tablicy

// Tutaj robimy tablice ze statkami usera

        short[][] userBoard;
        userBoard = new short[17][17];

//Zapętalmy by grać aż countHitUserBoard =howManyShipsOnBoard -> tyle jest statków na tablicy, czyli wszystkie statki będą zestrzelone

        while (countHitUserBoard < howManyShipsOnBoard ) {
            System.out.printf("Jest %d pól do zbicia\n", howManyShipsOnBoard - countHitUserBoard);

//    Wyświetlam tablice
//                [ ]- brak strzału 0
//                [*]- miss 3
//                [X]- hit  1
            System.out.println("    A  B  C  D  E  F  G  H  I  J");
            for (int i = 4; i < 14; i++) {
                System.out.printf("%2d ",(i + 1 -4));
                for (int j = 4; j < 14; j++) {
                    if (userBoard[i][j] == 0) {
                        System.out.print("[ ]");
                    } else if (userBoard[i][j] == 1) {
                        System.out.print("[X]");
                    } else System.out.print("[*]");
                }
                System.out.println();
            }

            int shotVertical = 0;
            int shotHorizontal;

            System.out.println(" \n\nPodaj strzał");
            String shot = scanner.next();
            String shotBig = shot.toUpperCase();
            char shotVerticalLetter = shotBig.charAt(0);
            char shotHorizontalLetter = shotBig.charAt(1);
            int len = shotBig.length();
             if ( len == 3) {
                 shotHorizontal = 10;
             } else {
                 shotHorizontal = Character.getNumericValue(shotHorizontalLetter);
             }

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
                    countHitUserBoard = howManyShipsOnBoard;
                    howManyShots = howManyShots -1;
                    break;
            }

            if (shotHorizontal != 99) {
                howManyShots++;

                if (board[shotHorizontal - 1 + 4][shotVertical + 4] == 0 || board[shotHorizontal - 1 + 4][shotVertical + 4] == 9 ) {
                    System.out.println("Pudło :(\n");
                    userBoard[shotHorizontal - 1 + 4][shotVertical + 4] = 3;
                } else if (board[shotHorizontal - 1 + 4][shotVertical + 4] == 1) {
//    Odejmuję 1, bo counHit doda się dopiero później

                    System.out.println("Trafiony :)\n");
                    userBoard[shotHorizontal - 1 + 4][shotVertical + 4] = 1;
                    countHitUserBoard++;
                }
            }
        }
        System.out.printf("Oddałeś %d strzałów. \nDzięki za grę", howManyShots);
        double p = Percent.percent(howManyShots, howManyShipsOnBoard);
        System.out.printf("Twoja celność to: %.1f P",p);
    }
}