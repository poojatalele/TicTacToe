// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.PrintStream;
import java.util.Scanner;

class Game extends Board {
   private Player player1 = new Player("Player X", 'X');
   private Player player2 = new Player("Player O", 'O');
   private Player currentPlayer;

   public Game(int var1) {
      super(var1);
      this.currentPlayer = this.player1;
   }

   public void start() {
      Scanner var1 = new Scanner(System.in);

      while(true) {
         while(true) {
            this.printBoard();
            PrintStream var10000 = System.out;
            String var10001 = this.currentPlayer.getName();
            var10000.println(var10001 + "'s turn (" + this.currentPlayer.getSymbol() + ")");
            var10000 = System.out;
            int var4 = this.getSize();
            var10000.print("Enter row and column (0 to " + (var4 - 1) + "): ");
            int var2 = var1.nextInt();
            int var3 = var1.nextInt();
            if (this.setCell(var2, var3, this.currentPlayer.getSymbol())) {
               if (this.checkWin(var2, var3, this.currentPlayer.getSymbol())) {
                  this.printBoard();
                  System.out.println(this.currentPlayer.getName() + " wins!");
                  return;
               }

               if (this.isFull()) {
                  this.printBoard();
                  System.out.println("It's a draw!");
                  return;
               }

               this.currentPlayer = this.currentPlayer == this.player1 ? this.player2 : this.player1;
            } else {
               System.out.println("Invalid move. Try again.");
            }
         }
      }
   }
}
