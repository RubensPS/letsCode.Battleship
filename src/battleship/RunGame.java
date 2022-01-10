package battleship;

import java.util.List;

public class RunGame {

    public static void main(String[] args) {

        //Chamando a página inicial
        StartScreen label = new StartScreen();

        //Criando objeto para imprimir tabuleiros
        PrintBoard Print = new PrintBoard();

        //Criando a lista de navios do jogador
        CreateShipList createPlayerList = new CreateShipList();
        List playerShipList = createPlayerList.generateList();

        //Criando a lista de navios do computador
        CreatePcShipList createPcList = new CreatePcShipList();
        List pcShipList = createPcList.generatePcShipList();

        //Criando tabuleiros
        Board playerBoard = new Board("playerBoard");
        Board pcBoard = new Board("pcBoard");

        //Posicionando navios
        PositionShips position = new PositionShips();
        position.positionShips(playerShipList, playerBoard);
        position.positionShips(pcShipList, pcBoard);

        //Iniciando o jogo
        StartRound start = new StartRound();
        start.startGame(playerBoard, pcBoard);
    }
}
