

public class PlayerTurn {
    private char player;
    public char setTurn(char turn) {
        if (turn =='X') {
            turn='O';
        }else {
            turn='X'; 
        }
        return turn;
    }
}
