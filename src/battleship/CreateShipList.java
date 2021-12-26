package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateShipList {

    private List<Cell> ShipList = new ArrayList();
    private Cell ship;
    private Scanner input = new Scanner(System.in);
    private int shipRow;
    private int shipColumn;
    private int shipNumber = 10;

    public void addShip(Cell ship) {
        ShipList.add(ship);
    }

    public void setShipStatus(Cell ship, CellStatus shipStatus) {
        ship.setCellStatus(shipStatus);
    }
    public CellStatus getShipStatus(Cell ship) {
        return ship.getCellStatus();
    }

    public void setShipRow(int shipRow) {
        this.shipRow = shipRow;
    }

    public void setShipColumn(int shipColumn) {
        this.shipColumn = shipColumn;
    }

    @Override
    public String toString() {
        return "CreateShipList{" +
                "ShipList=" + ShipList +
                '}';
    }

    public List<Cell> generateList() {
        while (shipNumber != 0) {
            //colocar esse bloco em um método
            System.out.printf("Selecione uma linha para o %s navio (de 0 e 9):", ShipOrder.values()[10 - shipNumber]);
            setShipRow(input.nextInt());
            while (shipRow < 0 | shipRow > 9) {
                System.out.println("A linha selecionada deve estar entre 0 e 9. Digite novamente.");
                setShipRow(input.nextInt());
            }

            System.out.printf("Selecione uma coluna para o %s navio (de 0 a 9):", ShipOrder.values()[10 - shipNumber]);
            setShipColumn(input.nextInt());
            while (shipColumn < 0 | shipColumn > 9) {
                System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                setShipColumn(input.nextInt());
            }

            ship = new Cell(shipRow, shipColumn, CellStatus.MY_SHIP);

            for (int i = 0; i < ShipList.size(); i++) {
                while (ship.getrow() == ShipList.get(i).getrow() && ship.getColumn() == ShipList.get(i).getColumn()) {
                    //Colocar esse bloco em um método.
                    System.out.printf("Posição já ocupada. Entre com outra coordenada para o %s navio.%n", ShipOrder.values()[10 - shipNumber]);
                    System.out.printf("Selecione uma linha para o %s navio (de 0 e 9):", ShipOrder.values()[10 - shipNumber]);
                    setShipRow(input.nextInt());
                    while (shipRow < 0 | shipRow > 9) {
                        System.out.println("A linha selecionada deve estar entre 0 e 9. Digite novamente.");
                        setShipRow(input.nextInt());
                    }

                    System.out.printf("Selecione uma coluna para o %s navio (de 0 a 9):", ShipOrder.values()[10 - shipNumber]);
                    setShipColumn(input.nextInt());
                    while (shipColumn < 0 | shipColumn > 9) {
                        System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                        setShipColumn(input.nextInt());
                    }

                    ship = new Cell(shipRow, shipColumn, CellStatus.MY_SHIP);
                }
            }
            addShip(ship);
            shipNumber--;
        }

        input.close();
        return ShipList;
    }

}
