

// import java.util.Scanner;
// import tictactoe.Game;
// import tictactoe.PlayerTurn;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        char[] gameBoard = {'0', '|', '1', '|', '2', '\n', '-', '+', '-', '+', '-', '\n', '3', '|', '4', '|', '5', '\n',
                '-', '+', '-', '+', '-', '\n', '6', '|', '7', '|', '8', '\n'};
        int depth=0;
        int[] posToIndex={0, 2, 4, 12, 14, 16, 24, 26, 28 };
        char player='X';
        Scanner sc = new Scanner(System.in);
        System.out.println(gameBoard);
        System.out.println("Turn = X");
        Game game1=new Game();
        PlayerTurn newTurn=new PlayerTurn();

        while (game1.winner(depth,gameBoard)){      // the game will repeat until a winner is found or depth = 9
            System.out.print("Enter Position between 0 and 8: ");
            int position=sc.nextInt();
            System.err.println();
            if(position>gameBoard.length){
                System.out.println("Error - Out of Bounds");
            } else{
                if(game1.checkBoard(position,gameBoard)){
                    System.out.println("Illegal Move! Try Again");
                } else{
                    depth++;
                    gameBoard[posToIndex[position]]=player;
                    System.out.println(gameBoard);
                    player=newTurn.setTurn(player);
                    if(depth!=9){
                        System.out.println("Turn = "+player);
                    }
                }
            }
        }
       newTurn.setTurn(player);
       System.out.println("Winner = "+player);
    }

}

