import java.util.Scanner;

class Game extends Board {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(int size) {
        super(size); // Inheritance → use Board constructor
        this.player1 = new Player("Player X", 'X');
        this.player2 = new Player("Player O", 'O');
        this.currentPlayer = player1;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row and column (0 to " + (getSize() - 1) + "): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // encapsulated board move
            if (!setCell(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // check win
            if (checkWin(row, col, currentPlayer.getSymbol())) {
                printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            // check draw
            if (isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // switch player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}