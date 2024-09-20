import java.util.Scanner;

public class Main {

    static char[][] board = {
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'}
    };


    static char currntPlayer = 'X';

    public static void main(String[] args) {
        boolean gameOnGoing = true;
        Scanner scanner = new Scanner(System.in);

        while (gameOnGoing) {
            printBoard();
            playerMove(scanner);
            gameOnGoing = checkGameStatus();
            switchPlayer();
        }
    }
    // wyświetalnie planszy
    static void printBoard() {
        System.out.println("--------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("--------");
    }
    static void playerMove(Scanner scanner) {
        int move;
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Gracz " + currntPlayer + ", wybierz pole (1-9): ");
            move = scanner.nextInt();

            if (move >= 1 && move <= 9 && isValidMove(move)) {
                placeMark(move);
                validMove = true;
            }
            else {
                System.out.println("Nieprawidłowy ruch, spróbuj ponownie.");
            }
        }
    }
    //sprawdzanie czy ruch jest dozwolony
    static boolean isValidMove(int move) {
        return switch (move){
            case 1 -> board[0][0] == '1';
            case 2 -> board[0][1] == '2';
            case 3 -> board[0][2] == '3';
            case 4 -> board[1][0] == '4';
            case 5 -> board[1][1] == '5';
            case 6 -> board[1][2] == '6';
            case 7 -> board[2][0] == '7';
            case 8 -> board[2][1] == '8';
            case 9 -> board[2][2] == '9';
            default -> false;
        };
    }
    //umieszczenie symbolu gracza na planszy
    static void placeMark(int move) {
        switch (move) {
            case 1 -> board[0][0] = currntPlayer;
            case 2 -> board[0][1] = currntPlayer;
            case 3 -> board[0][2] = currntPlayer;
            case 4 -> board[1][0] = currntPlayer;
            case 5 -> board[1][1] = currntPlayer;
            case 6 -> board[1][2] = currntPlayer;
            case 7 -> board[2][0] = currntPlayer;
            case 8 -> board[2][1] = currntPlayer;
            case 9 -> board[2][2] = currntPlayer;
        }
    }
    //zmiana gracza
    static void switchPlayer() {
        currntPlayer = (currntPlayer == 'X') ? 'O' : 'X';
    }
    static boolean checkGameStatus() {
        if (checkWinner()){
            printBoard();
            System.out.printf("Gracz " + currntPlayer + "wygrywa!");
            return false;
        }
        if(checkDraw()) {
            printBoard();
            System.out.println("Remis!");
            return false;
        }
        return true;
    }
    static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currntPlayer && board[i][1] == currntPlayer && board[i][2] == currntPlayer) {
                return true;
            }
            if (board[0][i] == currntPlayer && board[1][i] == currntPlayer && board[2][i] == currntPlayer){
                return true;
            }
        }
        return (board[0][0] == currntPlayer && board[1][1] == currntPlayer && board[2][2] == currntPlayer) ||
                (board[0][2] == currntPlayer && board[1][1] == currntPlayer && board[2][2] == currntPlayer);
    }
    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

}