package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatePcShipList {

    private List<Cell> pcShipList = new ArrayList();
    private Cell ship;
    private int shipRow;
    private int shipColumn;
    private int shipNumber = 10;
    private Random random = new Random();

    private void setShipRow(int shipRow) { this.shipRow = shipRow; }

    private void setShipColumn(int shipColumn) { this.shipColumn = shipColumn; }

    private void addShip (Cell ship) { pcShipList.add(ship); }

    public List<Cell> generatePcShipList() {
        while (shipNumber != 0) {
            setShipRow(random.nextInt(9));
            setShipColumn(random.nextInt(9));
            ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
            while (pcShipList.contains(ship)) {
                setShipRow(random.nextInt(9));
                setShipColumn(random.nextInt(9));
                ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
            }
            addShip(ship);
            shipNumber--;
        }
        return pcShipList;
    }

}
