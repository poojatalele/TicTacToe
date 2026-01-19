import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size : ");
        int n = sc.nextInt();

        Game game = new Game(n);
        game.start();
    }
}