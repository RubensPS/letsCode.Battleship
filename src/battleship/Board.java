package battleship;

import com.sun.jdi.Value;

public class Board {

    int maxRow = 10;
    int maxColumn = 10;
    Cell[][] board;

    public Board() {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.board = board;
        fillBoard();
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }

    public Cell[][] fillBoard() {
        board = new Cell[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                board[row][column] = new Cell(row, column, CellStatus.WATER);
            }
        }
        return board;
    }
}
