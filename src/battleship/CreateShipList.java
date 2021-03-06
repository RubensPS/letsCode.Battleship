package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class CreateShipList {

    private List<Cell> shipList = new ArrayList();
    private Cell ship;
    private Scanner input = new Scanner(System.in);
    private String positioningMethod;
    private Random random = new Random();
    private String selectRow;
    private String selectColumn;
    private int shipRow;
    private int shipColumn;
    private int shipNumber = 10;

    private void addShip(Cell ship) {
        shipList.add(ship);
    }

    private void setSelectRow(String selectRow) { this.selectRow = selectRow; }

    private void setSelectColumn(String selectColumn) { this.selectColumn = selectColumn; }

    private void setShipRow(int shipRow) { this.shipRow = shipRow; }

    private void setShipColumn(int shipColumn) {
        this.shipColumn = shipColumn;
    }

    @Override
    public String toString() {
        return "CreateShipList{" +
                "ShipList=" + shipList +
                '}';
    }

    private int rowSymbolSwap() {
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

    private int columnSymbolSwap() {
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
        System.out.printf("SELECIONE O MODO DE POSICIONAMENTO DOS NAVIOS!!!%n" +
                            "1 - AUTOM??TICO" + "        " + "2 - MANUAL%n" +
                            "Modo: ");
        positioningMethod = input.next();
        while (!Pattern.matches("[12]", positioningMethod)) {
            System.out.printf("SELECIONE UM DOS MODOS DISPON??VEIS!!!%n" +
                    "1 - AUTOM??TICO" + "        " + "2 - MANUAL%n" +
                    "Modo: ");
            positioningMethod = input.next();
        }

        if (positioningMethod.equals("1") ) {
            while (shipNumber != 0) {
                setShipRow(random.nextInt(9));
                setShipColumn(random.nextInt(9));
                ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
                while (shipList.contains(ship)) {
                    setShipRow(random.nextInt(9));
                    setShipColumn(random.nextInt(9));
                    ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
                }
                addShip(ship);
                shipNumber--;
            }
        } else if (positioningMethod.equals("2")) {
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

                ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);

                while (shipList.contains(ship)) {
                    System.out.printf("Posi????o j?? ocupada. Entre com outra coordenada para o %s navio.%n", ShipOrder.values()[10 - shipNumber]);

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

                    ship = new Cell(shipRow, shipColumn, CellStatus.SHIP);
                }
                addShip(ship);
                shipNumber--;
            }
        } else System.err.println("!!!ERRO NA ESCOLHA DO MODO DE GERA????O DA LISTA!!!");

        System.out.println("----------------------------------------------------------------");
        return shipList;
    }

}