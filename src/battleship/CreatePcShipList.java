package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatePcShipList {

    private List<Cell> PcShipList = new ArrayList();
    private Cell ship;
    private int shipRow;
    private int shipColumn;
    private int shipNumber = 10;
    private Random random = new Random();

    public void setShipRow(int shipRow) { this.shipRow = shipRow; }

    public void setShipColumn(int shipColumn) { this.shipColumn = shipColumn; }

    public void addShip (Cell ship) { PcShipList.add(ship); }

    public List<Cell> generatePcShipList() {
        while (shipNumber != 0) {
            setShipRow(random.nextInt(9));
            setShipColumn(random.nextInt(9));

            for (int i = 0; i < PcShipList.size(); i++) {
                while (shipRow == PcShipList.get(i).getRow() && shipColumn == PcShipList.get(i).getColumn()) {
                    setShipRow(random.nextInt(9));
                    setShipColumn(random.nextInt(9));
                }
            }

            ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
            addShip(ship);
            shipNumber--;
        }
//
        return PcShipList;
    }
}
