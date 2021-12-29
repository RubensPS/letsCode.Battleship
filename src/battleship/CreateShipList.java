package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class CreateShipList {

    private List<Cell> ShipList = new ArrayList();
    private Cell ship;
    private Scanner input = new Scanner(System.in);
    private String selectRow;
    private String selectColumn;
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

    public void setSelectRow(String selectRow) { this.selectRow = selectRow; }

    public void setSelectColumn(String selectColumn) { this.selectColumn = selectColumn; }

    public void setShipRow(int shipRow) { this.shipRow = shipRow; }

    public void setShipColumn(int shipColumn) {
        this.shipColumn = shipColumn;
    }

    @Override
    public String toString() {
        return "CreateShipList{" +
                "ShipList=" + ShipList +
                '}';
    }

    public int rowSymbolSwap() {
        int row = 0;

        switch (selectRow) {
            case "A":
                row = 0;
                break;
            case "B":
                row = 1;
                break;
            case "C":
                row = 2;
                break;
            case "D":
                row = 3;
                break;
            case "E":
                row = 4;
                break;
            case "F":
                row = 5;
                break;
            case "G":
                row = 6;
                break;
            case "H":
                row = 7;
                break;
            case "I":
                row = 8;
                break;
            case "J":
                row = 9;
                break;
            default:
                System.err.println("Row doesn't match!!!");
        }
        return row;
    }

    public int columnSymbolSwap() {
        int column = 0;

        switch (selectColumn) {
            case "0":
                column = 0;
                break;
            case "1":
                column = 1;
                break;
            case "2":
                column = 2;
                break;
            case "3":
                column = 3;
                break;
            case "4":
                column = 4;
                break;
            case "5":
                column = 5;
                break;
            case "6":
                column = 6;
                break;
            case "7":
                column = 7;
                break;
            case "8":
                column = 8;
                break;
            case "9":
                column = 9;
                break;
            default:
                System.err.println("Column doesn't match!!!");
        }
        return column;
    }

    public List<Cell> generateList() {
        while (shipNumber != 0) {
            System.out.printf("Selecione uma linha para o %s navio (de A a J):", ShipOrder.values()[10 - shipNumber]);
            setSelectRow(input.next().toUpperCase());
            while (!Pattern.matches("[A-J]", selectRow)) {
                System.out.println("A linha selecionada deve estar entre A e J. Digite novamente.");
                setSelectRow(input.next().toUpperCase());
            }
            setShipRow(rowSymbolSwap());

            System.out.printf("Selecione uma coluna para o %s navio (de 0 a 9):", ShipOrder.values()[10 - shipNumber]);
            setSelectColumn(input.next());
            while (!Pattern.matches("[\\d]", selectColumn)) {
                System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                setSelectColumn(input.next());
            }
            setShipColumn(columnSymbolSwap());

            ship = new Cell(shipRow, shipColumn, CellStatus.MY_SHIP);

            for (int i = 0; i < ShipList.size(); i++) {
                while (ship.getrow() == ShipList.get(i).getrow() && ship.getColumn() == ShipList.get(i).getColumn()) {
                    System.out.printf("Posição já ocupada. Entre com outra coordenada para o %s navio.%n", ShipOrder.values()[10 - shipNumber]);

                    System.out.printf("Selecione uma linha para o %s navio (de 0 e 9):", ShipOrder.values()[10 - shipNumber]);
                    setSelectRow(input.next().toUpperCase());
                    while (!Pattern.matches("[A-J]", selectRow)) {
                        System.out.println("A linha selecionada deve estar entre A e J. Digite novamente.");
                        setSelectRow(input.next().toUpperCase());
                    }
                    setShipRow(rowSymbolSwap());

                    System.out.printf("Selecione uma coluna para o %s navio (de 0 a 9):", ShipOrder.values()[10 - shipNumber]);
                    setSelectColumn(input.next());
                    while (!Pattern.matches("[\\d]", selectColumn)) {
                        System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                        setSelectColumn(input.next());
                    }
                    setShipColumn(columnSymbolSwap());

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