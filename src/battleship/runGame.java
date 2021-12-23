package battleship;

import java.lang.reflect.Array;
import java.util.Arrays;

public class runGame {

    public static void main(String[] args) {
    Board board = new Board();
    PrintBoard print = new PrintBoard();
    print.printBoard(board);
    }
}
