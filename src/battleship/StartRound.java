package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class StartRound {

    private List<Cell> playerShotList = new ArrayList();
    private List<Cell> pcShotList = new ArrayList();
    private Cell shot;
    private int shotCounter = 1;
    private String selectRow;
    private String selectColumn;
    private int shotRow;
    private int shotColumn;
    private int playerShipNumber = 10;
    private int pcShipNumber = 10;
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();
    private PrintBoard Print = new PrintBoard();

    public void addPlayerShot(Cell shot) { playerShotList.add(shot); }

    public void addPcShot(Cell shot) { pcShotList.add(shot); }

    public void setSelectRow(String selectRow) { this.selectRow = selectRow; }

    public void setSelectColumn(String selectColumn) { this.selectColumn = selectColumn; }

    public void setShotRow(int shotRow) { this.shotRow = shotRow; }

    public void setShotColumn(int shotColumn) { this.shotColumn = shotColumn; }

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
                System.err.println("Shot row doesn't match!!!");
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
                System.err.println("Shot column doesn't match!!!");
        }
        return column;
    }

    public void startGame(Board playerBoard, Board pcBoard) {
        System.out.println("O jogo começou. Entre com as coordenadas da sua tentativa!");
        while (playerShipNumber > 0 || pcShipNumber > 0) {
            System.out.printf("Selecione uma linha para a tentativa %d (de A a J):", shotCounter);
            setSelectRow(input.next().toUpperCase());
            while (!Pattern.matches("[A-J]", selectRow)) {
                System.out.println("A linha selecionada deve estar entre A e J. Digite novamente.");
                setSelectRow(input.next().toUpperCase());
            }
            setShotRow(rowSymbolSwap());

            System.out.printf("Selecione uma coluna para o tentativa %d (de 0 a 9):", shotCounter);
            setSelectColumn(input.next());
            while (!Pattern.matches("[\\d]", selectColumn)) {
                System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                setSelectColumn(input.next());
            }
            setShotColumn(columnSymbolSwap());

            for (int i = 0; i < playerShotList.size(); i++) {
                while (shotRow == playerShotList.get(i).getRow() && shotColumn == playerShotList.get(i).getColumn()) {
                    System.out.printf("Posição já atacada, entre com uma nova coordenada para a tentativa %d.", shotCounter);
                    System.out.printf("Selecione uma linha para a tentativa %d (de A a J):", shotCounter);
                    setSelectRow(input.next().toUpperCase());
                    while (!Pattern.matches("[A-J]", selectRow)) {
                        System.out.println("A linha selecionada deve estar entre A e J. Digite novamente.");
                        setSelectRow(input.next().toUpperCase());
                    }
                    setShotRow(rowSymbolSwap());

                    System.out.printf("Selecione uma coluna para o tentativa %d (de 0 a 9):", shotCounter);
                    setSelectColumn(input.next());
                    while (!Pattern.matches("[\\d]", selectColumn)) {
                        System.out.println("A coluna selecionada deve estar entre 0 e 9. Digite novamente.");
                        setSelectColumn(input.next());
                    }
                    setShotColumn(columnSymbolSwap());
                }
            }

            if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER ||
                    pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.MISS ||
                    pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.HIT) {
                if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER) {
                    playerBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.MISS);
                } else if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP) {
                    playerBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.MISS_WITH_SHIP);
                } else System.out.println("Verifique o status da célula TIRO ÁGUA");

            } else if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP ||
                    pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.MISS_WITH_SHIP ||
                    pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.HIT_WITH_SHIP) {
                if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER) {
                    playerBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.HIT);
                    pcShipNumber--;
                } else if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP) {
                    playerBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.HIT_WITH_SHIP);
                    pcShipNumber--;
                } else System.out.println("Verifique o status da célula TIRO NAVIO BLOCO JOGADOR");
            } else System.out.println("Verifique o status da célula da MAQUINA");

            shot = new Cell(shotRow, shotColumn, playerBoard.getCell(shotRow, shotColumn).getCellStatus());
            addPlayerShot(shot);

            setShotRow(random.nextInt(9));
            setShotColumn(random.nextInt(9));

            for (int i = 0; i < pcShotList.size(); i++) {
                while (shotRow == pcShotList.get(i).getRow() && shotColumn == pcShotList.get(i).getColumn()) {
                    setShotRow(random.nextInt(9));
                    setShotColumn(random.nextInt(9));
                }
            }

            if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER ||
                    playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.MISS ||
                    playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.HIT) {
                if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER) {
                    pcBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.MISS);
                } else if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP) {
                    pcBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.MISS_WITH_SHIP);

                } else if (playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP ||
                        playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.MISS_WITH_SHIP ||
                        playerBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.HIT_WITH_SHIP) {
                    if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.WATER) {
                        pcBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.HIT);
                        playerShipNumber--;
                    } else if (pcBoard.getCell(shotRow, shotColumn).getCellStatus() == CellStatus.SHIP) {
                        pcBoard.getCell(shotRow, shotColumn).setCellStatus(CellStatus.HIT_WITH_SHIP);
                        playerShipNumber--;
                    } else System.out.println("Verifique o status da célula TIRO NAVIO BLOCO MAQUINA");
                }
            } else System.out.println("Verifique o status da célula do JOGADOR");

            shot = new Cell(shotRow, shotColumn, pcBoard.getCell(shotRow, shotColumn).getCellStatus());
            addPcShot(shot);

            Print.printBoard(playerBoard);
            Print.printBoard(pcBoard);
            System.out.println(playerShipNumber);
            System.out.println(pcShipNumber);

            if (pcShipNumber == 0){
                System.out.println("PARABÉNS, VOCÊ AFUNDOU TODOS OS NAVIOS DO INIMIGO!!!");
            } else if (playerShipNumber == 0) {
                System.out.println("O INIMIGO AFUNDOU TODOS OS SEUS NAVIOS, VOCÊ PERDEU A GUERRA!!!");
            }
        }
        input.close();
    }
}
