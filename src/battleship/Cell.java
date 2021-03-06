package battleship;

import java.util.Objects;

public class Cell {

    private int row;
    private int column;
    private CellStatus cellStatus;

    public Cell(int row, int column, CellStatus cellStatus) {
        this.row = row;
        this.column = column;
        this.cellStatus = cellStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && column == cell.column && cellStatus == cell.cellStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, cellStatus);
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public int getRow() {
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
                symbol = " ~ ";
                break;
            case WATER:
                symbol = "   ";
                break;
            case SHIP:
                symbol = " N ";
                break;
            case HIT_WITH_SHIP:
                symbol = " X ";
                break;
            case MISS_WITH_SHIP:
                symbol = " n ";
                break;
            default:
                System.err.println("cellStatus doesn't match!!!");
        }
        return symbol;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                ", cellStatus=" + cellStatus +
                '}';
    }
}
