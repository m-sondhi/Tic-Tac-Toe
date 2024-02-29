

public class Game {
    private int[] posToIndex = {0, 2, 4, 12, 14, 16, 24, 26, 28};
    public boolean checkBoard(int position,char[] gameBoard){
        if(gameBoard[posToIndex[position]]=='X' || gameBoard[posToIndex[position]]=='O'){
            return true;
        }
        return false;
    }



    public boolean winner(int depth,char[] gameBoard){
        char winner='?';
        for(int i=0;i<3;i++){                                                  // checking columns
            if(
                    gameBoard[posToIndex[i]]==gameBoard[posToIndex[i+3]]
                            && gameBoard[posToIndex[i+3]]==gameBoard[posToIndex[i+6]]){
                winner=gameBoard[posToIndex[i]];
                break;
            }
        }
        if(winner=='?'){                                             // checking diagonal
            if(gameBoard[posToIndex[0]]==gameBoard[posToIndex[4]]                  // top-left to bottom-right
                    && gameBoard[posToIndex[4]]==gameBoard[posToIndex[8]]){
                winner=gameBoard[posToIndex[0]];
            }
            if(gameBoard[posToIndex[2]]==gameBoard[posToIndex[4]]                 // top-right to bottom-left
                    && gameBoard[posToIndex[4]]==gameBoard[posToIndex[6]]){
                winner=gameBoard[posToIndex[2]];
            }
        }

        if(winner == '?'){                                            // checking rows
            for (int i = 0; i <= 6; i+=3){
                if(gameBoard[posToIndex[i]]==gameBoard[posToIndex[i+1]]
                        && gameBoard[posToIndex[i+1]]==gameBoard[posToIndex[i+2]]){
                    winner=gameBoard[posToIndex[i]];
                    break;
                }
            }
        }
        if (depth == 9) {
            System.out.println("The Game was a Tie!");
            System.exit(0);
        } else if (winner != '?'){
            System.out.println("The winner is " + winner);
            System.exit(0);
        }
        return true;

    }
}
