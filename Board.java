class Board {
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initBoard();
    }

    // Encapsulated: Only this class can directly modify board
    private void initBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public boolean setCell(int row, int col, char symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != ' ') {
            return false; // invalid move
        }
        board[row][col] = symbol;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    // Check win for a given symbol at position
    public boolean checkWin(int row, int col, char symbol) {
        int n = size;
        boolean win;

        win = true;
        for (int j = 0; j < n; j++) {
            if (board[row][j] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        if (row == col) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        if (row + col == n - 1) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - 1 - i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
