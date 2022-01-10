package battleship;

import java.util.List;

public class Board {

    private final String name;
    int maxRow = 10;
    int maxColumn = 10;
    Cell[][] board;

    public String getName() {
        return name;
    }

    public Board(String name) {
        this.name = name;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.board = board;
        fillBoard();
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }
    public void setShipCell(List<Cell> shipList, int index) {
        board[shipList.get(index).getRow()][shipList.get(index).getColumn()] = shipList.get(index);
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
