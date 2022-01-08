package battleship;

import java.util.List;

public class PositionShips {


    public void positionShips(List shipList, Board board) {
        for (int ship = 0; ship < shipList.size(); ship++) {
            board.setShipCell(shipList, ship);
        }
    }

}
