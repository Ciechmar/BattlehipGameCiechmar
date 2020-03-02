import java.util.Random;

public class AppRandom {

    public static void main(String[] args) {

        Random generator = new Random();
//        Tablica jest o 3 wieksza by nie wyrzucało exeptiona ze poza skalą,
//        a na pozycjach 10 wsadzone 9, by przy losowaniu położenia nie wsadzało statku poza tablice 10x10
        byte [][]board = new byte[13][13];
        for (int i = 0; i < 10; i++) {
            board[i][10]=9;
            board[10][i]=9;
        }

//Wstawiam losowo statki
//        0- brak statku
//        1- jest statek
//        9- pole niedozwolone
        byte pozytion = 0;
        do {
//Losowanie 4 masztowca

            int i = generator.nextInt(9);
            int j = generator.nextInt(9);

            System.out.println("Miejsce w tablicy to " + i + j);

//        Losowanie kierunku:
            int k = generator.nextInt(2);
            System.out.println("K: " + k);
            if (k == 1) { /*Ułożenie pionowe*/

                int l = 0;
                int putShip = 0;
                while (l < 4) {

                    if (board[i + l][j] == 0) {
                        System.out.println("i:" + (i + l) + " j:" + j + " l:" + l);
                        System.out.println("na pozycji " + (i + l) + j + " jest " + board[i + l][j]);
                        l++;
                        putShip++;
                    } else {
                        break;
                    }
                }

                switch (putShip) {
                    case 4:
                        board[i][j] = 1;
                        board[i + 1][j] = 1;
                        board[i + 2][j] = 1;
                        board[i + 3][j] = 1;
                        pozytion = 1;
                        break;
                    default:
                        System.out.println("Nie miesci się");
                        break;
                }

            } else { /*ułożenie poziome*/

                int l = 0;
                int putShip = 0;
                while (l < 4) {

                    if (board[i][j + l] == 0) {
                        System.out.println("i:" + i + " j:" + (j + l) + " l:" + l);
                        System.out.println("na pozycji " + i + (j + l) + " jest " + board[i + l][j]);
                        l++;
                        putShip++;
                    } else {
                        break;
                    }
                }

                switch (putShip) {
                    case 4:
                        board[i][j] = 1;
                        board[i][j + 1] = 1;
                        board[i][j + 2] = 1;
                        board[i][j + 3] = 1;
                        pozytion = 1;
                        break;
                    default:
                        System.out.println("Nie miesci się");
                        break;
                }

            }
            System.out.println("Gdy k =1  więc" +board[i+1][j] + board[i+2][j] +board[i+3][j] + board[i][j]  );
            System.out.println("Gdy k = 0 więc" + board[i][j+1] + board[i][j+2] +board[i][j+3] + board[i][j]  );

        } while (pozytion != 1);


        System.out.println("   A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 10; j++) {
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
