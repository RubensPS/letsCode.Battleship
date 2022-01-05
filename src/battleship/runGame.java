package battleship;

import java.util.ArrayList;
import java.util.List;

public class runGame {

    public static void main(String[] args) {

        CreateShipList createplayerList = new CreateShipList();
        List playerShipList = createplayerList.generateList();
        //System.out.println(playerShipList);
        Board player = new Board();
        PrintBoard playerPrint = new PrintBoard();
        //playerPrint.printBoard(player);
        PositionShips playerPositions = new PositionShips();
        playerPositions.positionShips(playerShipList, player);
        playerPrint.printBoard(player);
    }
}
