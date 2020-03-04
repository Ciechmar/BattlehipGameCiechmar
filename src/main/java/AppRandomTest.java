import java.util.Random;
//ToDo:Obsługa exeptiona, gdy statek poza tab-> zrób tablice 10x10

// Gra w statki w tablicy 16x16, z widoczną częścia tylko od 4-16. Reszta potrzebna do obsługi losowania.

public class AppRandomTest {

    public static void main(String[] args) {

        Random generator = new Random();
//        Tablica jest o 3 wieksza by nie wyrzucało exeptiona ze poza skalą,
//        a na pozycjach 10 wsadzone 9, by przy losowaniu położenia nie wsadzało statku poza tablice 10x10
        byte [][]board = new byte[17][17];

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
        System.out.println("Tablica ograniczona");
        int id;
        int iloscMasztow = 0;
        for (int n = 0; n < 9 ; n++) {
            id = n;
            switch (id){
                case 0: iloscMasztow = 4; break;
                case 1: iloscMasztow = 3; break;
                case 2: iloscMasztow = 3; break;
                case 3:
                case 4:
                case 5: iloscMasztow = 2; break;
                case 6:
                case 7:
                case 8:
                case 9: iloscMasztow = 1; break;
            }

            byte pozytion = 0;
//        Zmienne czy stoi statek:
            int isSpotFree = 0;
            do {
                int i = generator.nextInt(9);
                int j = generator.nextInt(9);

                i = i + 4;
                j = j + 4;

//        Losowanie kierunku:
                int k = generator.nextInt(2);
                if (k == 1) { /*Ułożenie pionowe*/
                    
                    while (isSpotFree < iloscMasztow) {

                        if (board[i + isSpotFree][j] == 0) {
                            isSpotFree++;
                        } else {
                            break;
                        }
                    }
//Jeżeli putShip =4 (czyli 4 miejsca były wolne, to  można postawić statek
                    if (isSpotFree == iloscMasztow) {
                        for (int m = 0; m < iloscMasztow; m++) {
                            board[i + m][j] = 1;
//                            board[i + m][j - 1] = 9;
//                            board[i + m][j + 1] = 9;
                            board[i - 1][j] = 9;
//                            board[i - 1][j - 1] = 9;
//                            board[i - 1][j + 1] = 9;
                            board[i + iloscMasztow][j] = 9;
//                            board[i + iloscMasztow][j - 1] = 9;
//                            board[i + iloscMasztow][j + 1] = 9;
                        }
                        pozytion = 1;
                    }

                } else { /*ułożenie poziome*/

                    while (isSpotFree < iloscMasztow) {

                        if (board[i][j + isSpotFree] == 0) {
                            isSpotFree++;
                        } else {
                            break;
                        }
                    }
                    for (int m = 0; m < iloscMasztow; m++) {
                        board[i][j + m] = 1;
//                        board[i + 1][j + m] = 9;
//                        board[i - 1][j + m] = 9;
//
                        board[i][j + iloscMasztow] = 9;
//                        board[i - 1][j + iloscMasztow] = 9;
//                        board[i + 1][j + iloscMasztow] = 9;
                        board[i][j - 1] = 9;
//                        board[i - 1][j - 1] = 9;
//                        board[i + 1][j - 1] = 9;
                    }

                    if (isSpotFree == iloscMasztow) {
                        pozytion = 1;
                    }
                }
            } while (pozytion != 1);










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





    }









}
