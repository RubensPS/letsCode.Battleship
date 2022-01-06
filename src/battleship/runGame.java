package battleship;

import java.util.ArrayList;
import java.util.List;

public class runGame {

    public static void main(String[] args) {

        //Criando a lista de navios do jogador
        /*CreateShipList createPlayerList = new CreateShipList();
        List playerShipList = createPlayerList.generateList();
        System.out.println(playerShipList);*/

        //Criando a lista de navios do computador
        CreatePcShipList createPcList = new CreatePcShipList();
        List pcShipList = createPcList.generatePcShipList();
        System.out.println(pcShipList);

        //Criando tabuleiro do jogador
        Board playerBoard = new Board();

        //Criando tabuleiro do computador
        Board machineBoard = new Board();

        //Criando objeto para imprimir tabuleiros
        PrintBoard Print = new PrintBoard();

        //Posicionando navios
        PositionShips position = new PositionShips();
        position.positionShips(pcShipList, machineBoard);

        //Imprimindo tabuleiros
        Print.printBoard(machineBoard);

        //Print.printBoard(player);

        //playerPositions.positionShips(playerShipList, player);
        //Print.printBoard(player);

    }
}
