package battleship;

public class Cell {

    private int row;
    private int column;
    private CellStatus cellStatus;

    public Cell(int line, int column, CellStatus cellStatus) {
        this.row = line;
        this.column = column;
        this.cellStatus = cellStatus;
    }

    public CellStatus getCellState() {
        return cellStatus;
    }

    public void setCellState(CellStatus cellState) {
        this.cellStatus = cellState;
    }

    public int getLine() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getSymbol() {
        String symbol = "";

        switch (cellStatus) {
            case HIT:
                symbol = " * ";
                break;
            case MISS:
                symbol = " - ";
                break;
            case WATER:
                symbol = "   ";
                break;
            case MY_SHIP:
                symbol = " N ";
                break;
            case HIT_WITH_MY_SHIP:
                symbol = " X ";
                break;
            case MISS_WITH_MY_SHIP:
                symbol = " n ";
                break;
            default:
                System.err.println("cellStatus doesn't match!!!");
        }
        return symbol;
    }

}
